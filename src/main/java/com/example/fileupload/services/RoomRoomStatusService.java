package com.example.fileupload.services;


import com.example.fileupload.dto.requests.RoomRoomStatusRequest;
import com.example.fileupload.dto.responses.RoomRoomStatusResponse;

import java.util.List;

public interface RoomRoomStatusService {
    public RoomRoomStatusResponse create(RoomRoomStatusRequest request);
    public List<RoomRoomStatusResponse> getAll();
    public RoomRoomStatusResponse update(RoomRoomStatusRequest request, Long id);
    public String delete(Long id);
    public RoomRoomStatusResponse getOne(Long id);
}
