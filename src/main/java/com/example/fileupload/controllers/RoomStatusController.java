package com.example.fileupload.controllers;

import com.example.fileupload.dto.requests.RoomStatusRequest;
import com.example.fileupload.dto.responses.RoomStatusResponse;
import com.example.fileupload.services.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room-status")
public class RoomStatusController {

    @Autowired
    private RoomStatusService roomStatusService;


    @PostMapping
    public ResponseEntity<RoomStatusResponse> save(@RequestBody RoomStatusRequest roomStatusRequest){
        return new ResponseEntity<RoomStatusResponse>(roomStatusService.create(roomStatusRequest), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoomStatusResponse>> getAll(){
        return new ResponseEntity<>(roomStatusService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomStatusResponse> getById(@PathVariable Long id){
        return new ResponseEntity<RoomStatusResponse>(roomStatusService.getOne(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomStatusResponse> update(@RequestBody  RoomStatusRequest roomStatusRequest, @PathVariable Long id){
        return new ResponseEntity<RoomStatusResponse>(roomStatusService.update(roomStatusRequest, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public Map<String,String> delete( @PathVariable Long id){
        Map<String,String> map = new HashMap<>();
        map.put("message",roomStatusService.delete(id));
        return map;
    }

}
