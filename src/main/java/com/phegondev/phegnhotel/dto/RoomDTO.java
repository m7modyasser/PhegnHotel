package com.phegondev.phegnhotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phegondev.phegnhotel.entity.Booking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RoomDTO {

    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String RoomDescription;
    private List<BookingDTO> bookings;
 ;

}
