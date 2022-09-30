package com.example.fileupload.controllers;

import com.example.fileupload.Repository.RoomRepository;
import com.example.fileupload.Repository.RoomRoomStatusRepository;
import com.example.fileupload.dto.mappers.RoomRoomStatusMapper;
import com.example.fileupload.dto.responses.RoomResponse;
import com.example.fileupload.dto.responses.RoomRoomStatusResponse;
import com.example.fileupload.entities.ImageModel;
import com.example.fileupload.dto.mappers.RoomMapper;
import com.example.fileupload.dto.requests.RoomRequest;
import com.example.fileupload.entities.RoomRoomStatus;
import com.example.fileupload.services.FileStorageService;
import com.example.fileupload.entities.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room-room-status")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomRoomStatusRepository roomRoomStatusRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private RoomRoomStatusMapper roomStatusMapper;

    @Autowired
    private FileStorageService fileStorageService;




    @PostMapping("/add")
    public RoomResponse saveRoom(@RequestBody RoomRequest roomRequest){
        Room room = roomMapper.requestToEntity(roomRequest);
        roomRepository.save(room);
        return roomMapper.entityToResponse(room);
    }



    //Upload File
    @PostMapping("/upload-file/{roomRoomId}")
    public RoomRoomStatusResponse saveAndUpload(@RequestParam("image") MultipartFile file, @PathVariable long roomRoomId) {
        RoomRoomStatus roomRoomStatus = roomRoomStatusRepository.findById(roomRoomId).orElseThrow(() -> new RuntimeException("Id Not Provide"));
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download-file/").path(fileName).toUriString();
        ImageModel uploadFileResponse = new ImageModel(fileName, fileDownloadUri, file.getContentType(), file.getSize(),roomRoomStatus);
        roomRoomStatus.addFiles(uploadFileResponse);
        return roomStatusMapper.entityToResponse(roomRoomStatus);
    }


/*    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
    }*/


/*
    @PostMapping("/upload-files")
    @Transactional
    public RoomResponse uploadMultipleFiles(@RequestParam("images") MultipartFile[] files,@RequestParam("name") String name) {
        Room room = new Room();
        List<ImageModel> images = Arrays.asList(files)
                .stream()
                .map(file -> {
                    String fileName = fileStorageService.storeFile(file);
                    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();
                    return new ImageModel(fileName, fileDownloadUri, file.getContentType(), file.getSize(),room);
                })
                .collect(Collectors.toList());
        roomRepository.save(room);
        return roomMapper.entityToResponse(room);
    }
*/




    @GetMapping("/download-file/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}