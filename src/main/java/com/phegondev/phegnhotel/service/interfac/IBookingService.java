package com.phegondev.phegnhotel.service.interfac;


import com.phegondev.phegnhotel.dto.Response;
import com.phegondev.phegnhotel.entity.Booking;

import java.util.Random;

public interface IBookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);
    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);


}
