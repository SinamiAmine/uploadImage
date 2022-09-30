package com.example.fileupload.services.Impl;


import com.example.fileupload.Repository.RoomStatusRepository;
import com.example.fileupload.dto.mappers.RoomStatusMapper;
import com.example.fileupload.dto.requests.RoomStatusRequest;
import com.example.fileupload.dto.responses.RoomStatusResponse;
import com.example.fileupload.entities.RoomStatus;
import com.example.fileupload.services.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    @Autowired
    private RoomStatusMapper mapper;

    @Autowired
    private RoomStatusRepository repository;

    @Override
    public RoomStatusResponse create(RoomStatusRequest roomStatusRequest) {
        RoomStatus roomStatusSaved = mapper.requestToEntity(roomStatusRequest);
        repository.save(roomStatusSaved);
        return mapper.entityToResponse(roomStatusSaved);
    }

    @Override
    public List<RoomStatusResponse> getAll() {
        List<RoomStatus> roomStatuses = repository.findAll();
        return roomStatuses.stream().map(roomStatus -> mapper.entityToResponse(roomStatus)).collect(Collectors.toList());
    }

    @Override
    public RoomStatusResponse update(RoomStatusRequest roomStatusRequest, Long id) {
        RoomStatus roomStatus = repository.findById(id).orElseThrow();
        roomStatus.setCode(roomStatusRequest.getCode());
        roomStatus.setLabel(roomStatus.getLabel());
        repository.save(roomStatus);
        return mapper.entityToResponse(roomStatus);
    }


    @Override
    public String delete(Long id) {
        RoomStatus roomStatus = repository.findById(id).orElseThrow();
        repository.delete(roomStatus);
        return "Record deleted successfully";
    }



    @Override
    public RoomStatusResponse getOne(Long id) {
        RoomStatus roomStatus = repository.findById(id).orElseThrow();
        return mapper.entityToResponse(roomStatus);
    }
}
