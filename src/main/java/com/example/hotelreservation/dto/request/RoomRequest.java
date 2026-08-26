package com.example.hotelreservation.dto.request;

import com.example.hotelreservation.entity.RoomType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomRequest {

    @NotBlank
    String roomNumber;

    @NotNull
    RoomType type;

    @Positive
    double pricePerNight;
}