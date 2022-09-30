package com.example.fileupload.dto.responses;


import com.example.fileupload.entities.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRoomStatusResponse {

    private Long id;
    private LocalDateTime dateInspection;
    private RoomStatusResponse roomStatus;
    private RoomResponse room;
    private String commentaire;
    private List<ImageModel> images;

}
