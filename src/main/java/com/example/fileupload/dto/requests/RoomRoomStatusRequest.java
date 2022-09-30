package com.example.fileupload.dto.requests;

import com.example.fileupload.entities.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRoomStatusRequest {

    private LocalDateTime dateInspection;

    private RequestIdDto roomStatus;

    private RequestIdDto room;

    private String commentaire;

    private Set<ImageModel> roomImages;

}
