package com.example.fileupload.Repository;

import com.example.fileupload.entities.RoomRoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRoomStatusRepository extends JpaRepository<RoomRoomStatus,Long> {
}
