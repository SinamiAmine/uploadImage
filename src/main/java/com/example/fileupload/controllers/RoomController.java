package com.example.fileupload.controllers;

import com.example.fileupload.dto.requests.RoomRequest;
import com.example.fileupload.dto.responses.RoomResponse;
import com.example.fileupload.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping
    public ResponseEntity<RoomResponse> save(@RequestBody RoomRequest roomRequest){
        return new ResponseEntity<RoomResponse>(roomService.create(roomRequest), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAll(){
        return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getById(@PathVariable Long id){
        return new ResponseEntity<RoomResponse>(roomService.getOne(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> update(@RequestBody  RoomRequest roomRequest, @PathVariable Long id){
        return new ResponseEntity<RoomResponse>(roomService.update(roomRequest, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable Long id){
        Map<String,String> map = new HashMap<>();
        map.put("message",roomService.delete(id));
        return map;
    }

}
