package com.example.fileupload.Repository;


import com.example.fileupload.entities.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatus,Long> {
}
