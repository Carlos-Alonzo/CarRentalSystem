package com.carrental.service.implementation;

import com.carrental.domain.reservation.Booking;
import com.carrental.service.contract.BookingServiceFunctions;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

public class BookingServiceImp implements BookingServiceFunctions
{
    private Map<Long, Booking> bookings;

    public BookingServiceImp() {bookings = new TreeMap<>();}

    @Override
    public Booking getBookingById(long reservationId)
    {
        return bookings.get(reservationId);
    }

    @Override
    public boolean addNewBooking(@NotNull Booking booking)
    {
        bookings.put(booking.getReservationId(), booking);
        return bookings.containsKey(booking.getReservationId());
    }

    @Override
    public boolean cancelBooking(long reservationId)
    {
        bookings.remove(reservationId);
        return !bookings.containsKey(reservationId);
    }
}
