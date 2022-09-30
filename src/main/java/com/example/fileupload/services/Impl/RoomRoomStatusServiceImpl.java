package com.example.fileupload.services.Impl;

import com.example.fileupload.Repository.RoomRepository;
import com.example.fileupload.Repository.RoomRoomStatusRepository;
import com.example.fileupload.Repository.RoomStatusRepository;
import com.example.fileupload.dto.mappers.RoomRoomStatusMapper;
import com.example.fileupload.dto.requests.RoomRoomStatusRequest;
import com.example.fileupload.dto.responses.RoomRoomStatusResponse;
import com.example.fileupload.entities.Room;
import com.example.fileupload.entities.RoomRoomStatus;
import com.example.fileupload.entities.RoomStatus;
import com.example.fileupload.services.RoomRoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomRoomStatusServiceImpl implements RoomRoomStatusService {


    @Autowired
    private RoomRoomStatusMapper roomStatusMapper;

    @Autowired
    private RoomRoomStatusRepository roomRoomStatusRepository;


    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomStatusRepository roomStatusRepository;

    @Override
    @Transactional
    public RoomRoomStatusResponse create(RoomRoomStatusRequest request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        RoomRoomStatus roomRoomStatus = roomStatusMapper.requestToEntity(request);
        RoomStatus roomStatus = roomStatusRepository.findById(request.getRoomStatus().getId()).orElseThrow();
        Room room = roomRepository.findById(request.getRoomStatus().getId()).orElseThrow();
        roomRoomStatus.setRoomStatus(roomStatus);
        roomRoomStatus.setRoom(room);
        roomRoomStatus.setDateInspection(localDateTime);
        roomRoomStatusRepository.save(roomRoomStatus);
        return roomStatusMapper.entityToResponse(roomRoomStatus);
    }

    @Override
    public List<RoomRoomStatusResponse> getAll() {
        return null;
    }

    @Override
    public RoomRoomStatusResponse update(RoomRoomStatusRequest request, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public RoomRoomStatusResponse getOne(Long id) {
        return null;
    }
}
