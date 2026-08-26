package com.example.hotelreservation.controller;

import com.example.hotelreservation.dto.request.BookingRequest;
import com.example.hotelreservation.dto.response.BookingResponse;
import com.example.hotelreservation.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingResponse createBooking(@Valid @RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping("/room/{roomId}")
    public List<BookingResponse> getBookingsByRoom(@PathVariable Long roomId) {
        return bookingService.getBookingsByRoom(roomId);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}