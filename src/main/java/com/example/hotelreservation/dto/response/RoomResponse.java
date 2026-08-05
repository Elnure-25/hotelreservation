package com.example.hotelreservation.dto.response;

import com.example.hotelreservation.entity.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomResponse {
    Long id;
    String roomNumber;
    RoomType type;
    double pricePerNight;
    boolean isAvailable;

}
