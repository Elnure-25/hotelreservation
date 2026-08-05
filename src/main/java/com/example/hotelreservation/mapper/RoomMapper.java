package com.example.hotelreservation.mapper;

import com.example.hotelreservation.dto.request.RoomRequest;

import com.example.hotelreservation.entity.Room;

public class RoomMapper {

    public Room toEntity(RoomRequest request) {

        Room room = new Room();

        room.setRoomNumber(request.getRoomNumber());
        room.setType(request.getType());
        room.setPricePerNight(request.getPricePerNight());
        room.setAvailable(true);

        return room;
    }
}
