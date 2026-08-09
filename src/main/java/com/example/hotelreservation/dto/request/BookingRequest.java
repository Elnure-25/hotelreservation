package com.example.hotelreservation.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {

    Long roomId;
    String guestName;
    LocalDate checkIn;
    LocalDate checkOut;
}
