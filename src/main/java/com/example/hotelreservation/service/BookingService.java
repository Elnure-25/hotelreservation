package com.example.hotelreservation.service;

import com.example.hotelreservation.dto.request.BookingRequest;
import com.example.hotelreservation.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {

    BookingResponse createBooking(BookingRequest request);

    List<BookingResponse> getBookingsByRoom(Long roomId);

    void deleteBooking(Long id);
}