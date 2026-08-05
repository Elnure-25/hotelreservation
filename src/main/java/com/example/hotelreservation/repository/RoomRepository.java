package com.example.hotelreservation.repository;

import com.example.hotelreservation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByIsAvailableTrue();

}
