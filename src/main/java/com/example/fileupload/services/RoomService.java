package com.example.fileupload.services;

import com.example.fileupload.dto.requests.RoomRequest;
import com.example.fileupload.dto.responses.RoomResponse;

import java.util.List;

public interface RoomService {

    public RoomResponse create(RoomRequest roomRequest);
    public List<RoomResponse> getAll();
    public RoomResponse update(RoomRequest roomRequest,Long id);
    public String delete(Long id);
    public RoomResponse getOne(Long id);

}
