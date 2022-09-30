package com.example.fileupload.controllers;


import com.example.fileupload.dto.requests.RoomRoomStatusRequest;
import com.example.fileupload.dto.responses.RoomRoomStatusResponse;
import com.example.fileupload.services.RoomRoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room-room-status")
public class RoomRoomStatusController {


    @Autowired
    private RoomRoomStatusService service;



    @PostMapping
    public ResponseEntity<RoomRoomStatusResponse> save(@RequestBody RoomRoomStatusRequest request){
        return new ResponseEntity<RoomRoomStatusResponse>(service.create(request), HttpStatus.OK);
    }
}
