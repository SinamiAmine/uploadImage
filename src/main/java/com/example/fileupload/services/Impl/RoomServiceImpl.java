package com.example.fileupload.services.Impl;

import com.example.fileupload.Repository.RoomRepository;
import com.example.fileupload.Repository.RoomStatusRepository;
import com.example.fileupload.dto.mappers.RoomMapper;
import com.example.fileupload.dto.mappers.RoomStatusMapper;
import com.example.fileupload.dto.requests.RoomRequest;
import com.example.fileupload.dto.responses.RoomResponse;
import com.example.fileupload.entities.Room;
import com.example.fileupload.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper mapper;

    @Autowired
    private RoomRepository repository;

    @Override
    public RoomResponse create(RoomRequest roomRequest) {
        Room room = mapper.requestToEntity(roomRequest);
        repository.save(room);
        return mapper.entityToResponse(room);
    }

    @Override
    public List<RoomResponse> getAll() {
        List<Room> rooms = repository.findAll();
        return rooms.stream().map(room -> mapper.entityToResponse(room)).collect(Collectors.toList());
    }

    @Override
    public RoomResponse update(RoomRequest roomRequest, Long id) {
        Room room = mapper.requestToEntity(roomRequest);
        room.setRoomNumero(roomRequest.getRoomNumero());
        repository.save(room);
        return mapper.entityToResponse(room);
    }

    @Override
    public String delete(Long id) {
        Room room = repository.findById(id).orElseThrow();
        repository.delete(room);
        return "Room Deleted ...";
    }

    @Override
    public RoomResponse getOne(Long id) {
        Room room = repository.findById(id).orElseThrow();
        return mapper.entityToResponse(room);
    }

}
