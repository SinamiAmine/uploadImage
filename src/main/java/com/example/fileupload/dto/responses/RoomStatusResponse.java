package com.example.fileupload.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatusResponse {

    private Long id;
    private String code;
    private String label;
}
