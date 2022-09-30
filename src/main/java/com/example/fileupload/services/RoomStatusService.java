package com.example.fileupload.services;

import com.example.fileupload.dto.requests.RoomStatusRequest;
import com.example.fileupload.dto.responses.RoomStatusResponse;

import java.util.List;

public interface RoomStatusService {

    public RoomStatusResponse create(RoomStatusRequest roomStatusRequest);
    public List<RoomStatusResponse> getAll();
    public RoomStatusResponse update(RoomStatusRequest roomStatusRequest,Long id);
    public String delete(Long id);
    public RoomStatusResponse getOne(Long id);
}
