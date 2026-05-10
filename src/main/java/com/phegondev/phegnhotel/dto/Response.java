package com.phegondev.phegnhotel.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.phegondev.phegnhotel.dto.BookingDTO;
import com.phegondev.phegnhotel.dto.RoomDTO;
import com.phegondev.phegnhotel.dto.UserDTO;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;
    private String message;

    private String token;
    private String role;
    private String expirationTime;
    private String bookingConfirmationCode;

    private UserDTO user;
    private RoomDTO room;
    private BookingDTO booking;
    private List<UserDTO> userList;
    private List<RoomDTO> roomList;
    private List<BookingDTO> bookingList;


}