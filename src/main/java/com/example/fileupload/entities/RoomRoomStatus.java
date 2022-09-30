package com.example.fileupload.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomRoomStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "roomstatus_id")
    private RoomStatus roomStatus;

    LocalDateTime dateInspection;

    String commentaire;

    @OneToMany(mappedBy = "roomRoomStatus",cascade = CascadeType.ALL)
    private List<ImageModel> images;

    public void addFiles(ImageModel imageModel){
        this.images.add(imageModel);
    }
}
