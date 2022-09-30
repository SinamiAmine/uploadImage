package com.example.fileupload.dto.requests;

import com.example.fileupload.entities.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private String roomNumero;
    private List<ImageModel> images;
}
