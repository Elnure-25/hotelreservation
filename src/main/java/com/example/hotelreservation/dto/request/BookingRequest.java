package com.example.hotelreservation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {

    @NotNull
    Long roomId;

    @NotBlank
    String guestName;

    @NotNull
    LocalDate checkIn;

    @NotNull
    LocalDate checkOut;
}