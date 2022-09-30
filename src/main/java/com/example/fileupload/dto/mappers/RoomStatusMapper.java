package com.example.fileupload.dto.mappers;


import com.example.fileupload.dto.requests.RoomRequest;
import com.example.fileupload.dto.requests.RoomStatusRequest;
import com.example.fileupload.dto.responses.RoomStatusResponse;
import com.example.fileupload.entities.RoomStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomStatusMapper {

    RoomStatusMapper INSTANCE = Mappers.getMapper( RoomStatusMapper.class );
    RoomStatusResponse entityToResponse(RoomStatus roomStatus);
    RoomStatus responseToEntity(RoomStatusResponse roomStatusResponse);
    RoomStatus requestToEntity(RoomStatusRequest roomStatusRequest);
    RoomStatusRequest entityToRequest(RoomStatus roomStatus);
}
