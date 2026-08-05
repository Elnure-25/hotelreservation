package com.example.hotelreservation.dto.request;
import com.example.hotelreservation.entity.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomRequest {
    String roomNumber;
    RoomType type;
    double pricePerNight;
}
