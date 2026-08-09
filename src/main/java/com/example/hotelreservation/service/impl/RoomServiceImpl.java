package com.example.hotelreservation.service.impl;

import com.example.hotelreservation.dto.request.RoomRequest;
import com.example.hotelreservation.dto.response.RoomResponse;
import com.example.hotelreservation.entity.Room;
import com.example.hotelreservation.service.RoomService;
import org.springframework.stereotype.Service;
import com.example.hotelreservation.mapper.RoomMapper;
import com.example.hotelreservation.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    @Override
    public RoomResponse createRoom(RoomRequest request) {
        Room room = roomMapper.toEntity(request);
        room = roomRepository.save(room);
        return roomMapper.toResponse(room);
    }
    @Override
    public List<RoomResponse> getAvailableRooms() {
        return roomRepository.findByIsAvailableTrue()
                .stream()
                .map(roomMapper::toResponse)
                .toList();
    }


}
