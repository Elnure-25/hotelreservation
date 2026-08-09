package com.example.hotelreservation.service;
import com.example.hotelreservation.dto.request.RoomRequest;
import com.example.hotelreservation.dto.response.RoomResponse;
import com.example.hotelreservation.entity.Room;
import com.example.hotelreservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoomService {
    RoomResponse createRoom(RoomRequest request);

    List<RoomResponse> getAvailableRooms();
}
