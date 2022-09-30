package com.example.fileupload.dto.responses;

import com.example.fileupload.entities.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {

    private Long id;
    private String roomNumero;
}
