package com.carrental.domain.user;
import com.carrental.domain.reservation.Booking;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Renter extends BaseUser
{
    private long renterId;
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) private List<Booking> bookings;
    public Renter()
    {
        super();
        bookings = new ArrayList<>();
    }

    public boolean addBooking(@NotNull Booking booking)
    {
        bookings.add(booking);
        return bookings.contains(booking);
    }

    public boolean removeBooking(@NotNull Booking booking)
    {
        bookings.remove(booking);
        return !bookings.contains(booking);
    }
}
