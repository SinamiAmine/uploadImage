package com.example.fileupload.dto.mappers;


import com.example.fileupload.dto.requests.RoomRequest;
import com.example.fileupload.dto.requests.RoomRoomStatusRequest;
import com.example.fileupload.dto.responses.RoomResponse;
import com.example.fileupload.dto.responses.RoomRoomStatusResponse;
import com.example.fileupload.entities.Room;
import com.example.fileupload.entities.RoomRoomStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomRoomStatusMapper {
    RoomRoomStatusMapper INSTANCE = Mappers.getMapper( RoomRoomStatusMapper.class );
    RoomRoomStatusResponse entityToResponse(RoomRoomStatus roomRoomStatus);
    RoomRoomStatus responseToEntity(RoomRoomStatusResponse roomRoomStatusResponse);
    RoomRoomStatus requestToEntity(RoomRoomStatusRequest roomRoomStatusRequest);
    RoomRoomStatusRequest entityToRequest(RoomRoomStatus roomRoomStatus);
}
