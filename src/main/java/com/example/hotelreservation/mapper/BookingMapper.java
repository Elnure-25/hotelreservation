package com.example.hotelreservation.mapper;

import com.example.hotelreservation.dto.request.BookingRequest;
import com.example.hotelreservation.dto.response.BookingResponse;
import com.example.hotelreservation.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toEntity(BookingRequest bookingRequest);

    BookingResponse toResponse(Booking booking);
}