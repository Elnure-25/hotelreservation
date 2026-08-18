package com.example.hotelreservation.service.impl;

import com.example.hotelreservation.dto.request.BookingRequest;
import com.example.hotelreservation.dto.response.BookingResponse;
import com.example.hotelreservation.entity.Booking;
import com.example.hotelreservation.exception.BookingNotFoundException;
import com.example.hotelreservation.exception.RoomNotFoundException;
import com.example.hotelreservation.mapper.BookingMapper;
import com.example.hotelreservation.repository.BookingRepository;
import com.example.hotelreservation.repository.RoomRepository;
import com.example.hotelreservation.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final RoomRepository roomRepository;

    @Override
    public BookingResponse createBooking(BookingRequest request) {

        Booking booking = bookingMapper.toEntity(request);

        var room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));

        long nights = ChronoUnit.DAYS.between(
                request.getCheckIn(),
                request.getCheckOut()
        );

        double totalPrice = nights * room.getPricePerNight();

        booking.setTotalPrice(totalPrice);

        Booking savedBooking = bookingRepository.save(booking);

        return bookingMapper.toResponse(savedBooking);
    }

    @Override
    public List<BookingResponse> getBookingsByRoom(Long roomId) {

        return bookingRepository.findByRoomId(roomId)
                .stream()
                .map(bookingMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteBooking(Long id) {

        bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));

        bookingRepository.deleteById(id);
    }
}