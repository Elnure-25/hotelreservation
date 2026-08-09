package com.example.hotelreservation.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {

    Long id;
    Long roomId;
    String guestName;
    LocalDate checkIn;
    LocalDate checkOut;
    double totalPrice;
}
