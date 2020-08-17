package com.carrental.service.contract;

import com.carrental.domain.car.RentalCar;
import com.carrental.domain.reservation.Booking;
import com.carrental.domain.user.Renter;

import java.util.Date;

public interface BookingServiceFunctions
{
    Booking getBookingById(long bookingId);
    boolean addNewBooking(Booking booking);
    boolean cancelBooking(long bookingId);
}
