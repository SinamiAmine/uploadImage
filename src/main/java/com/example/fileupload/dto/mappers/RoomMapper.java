package com.example.fileupload.dto.mappers;
import com.example.fileupload.dto.responses.RoomResponse;
import com.example.fileupload.dto.requests.RoomRequest;
import com.example.fileupload.entities.Room;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper( RoomMapper.class );
    RoomResponse entityToResponse(Room room);
    Room responseToEntity(RoomResponse roomResponse);
    Room requestToEntity(RoomRequest roomRequest);
    RoomRequest entityToRequest(Room room);
}
