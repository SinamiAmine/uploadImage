package com.example.fileupload.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_roomstatus")
@Getter
@Setter
public class RoomStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String label;

    @OneToMany(mappedBy = "roomStatus")
    Set<RoomRoomStatus> roomRoomStatuses;

}
