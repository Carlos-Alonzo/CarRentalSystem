package com.carrental.service.implementation;

import com.carrental.domain.address.Address;
import com.carrental.domain.car.CarType;
import com.carrental.domain.car.RentalCar;
import com.carrental.domain.car.RentalClassTypes;
import com.carrental.domain.reservation.Booking;
import com.carrental.domain.user.Renter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookingServiceImpTest
{

    BookingServiceImp testBookingServiceImp;
    Booking testBooking;
    Renter testRenter;
    Address testAddress;
    RentalCar testRentalCar;

    @BeforeEach
    void setUp()
    {
        testBookingServiceImp = new BookingServiceImp();
        testRenter = new Renter();
        testRenter.setRenterId(1l);
        testRenter.setEmail("jon@abe.com");
        testRenter.setPwd("12345678");
        testRenter.setFirstName("Jon");
        testRenter.setLastName("Zon");

        testAddress = Address.builder().address1("25 Elliot Drive").city("Chelsea").state("MA").zipCode("01849").country("USA").build();
        testRenter.setResidentialAddress(testAddress);
        testRenter.setBillingAddress(testAddress);

        testRentalCar = new RentalCar();
        testRentalCar.setRentalClass(RentalClassTypes.VAN);
        testRentalCar.setRentalId(1l);
        testRentalCar.setDailyRate(49);
        testRentalCar.setVIN("YHNF345690890");
        testRentalCar.setMake("Toyota");
        testRentalCar.setModel("Sienna");
        testRentalCar.setYear(2020);
        testRentalCar.setCarType(CarType.VAN);

        testBooking = Booking.builder()
                             .reservationId(1)
                             .startDate(LocalDate.parse("2020-08-17"))
                             .endDate(LocalDate.parse("2020-08-24"))
                             .rentalCar(testRentalCar)
                             .renter(testRenter)
                             .build();
        testBooking.setFees();

        testBookingServiceImp.addNewBooking(testBooking);
    }

    @Test
    void getBookingById()
    {
        assertThat(testBookingServiceImp.getBookingById(1))
                .isNotNull()
                .isInstanceOf(Booking.class)
                .isEqualToComparingFieldByField(testBooking);
    }

    @Test
    void addNewBooking()
    {
        testBooking = Booking.builder()
                             .reservationId(2)
                             .startDate(LocalDate.parse("2020-08-16"))
                             .endDate(LocalDate.parse("2020-08-21"))
                             .rentalCar(testRentalCar)
                             .renter(testRenter)
                             .build();
        testBooking.setFees();

        assertThat(testBookingServiceImp.addNewBooking(testBooking)).isTrue();
        assertThat(testBookingServiceImp.getBookingById(2)).isEqualToComparingFieldByField(testBooking);
    }

    @Test
    void cancelBooking()
    {
        Booking testBooking1 = Booking.builder()
                             .reservationId(1)
                             .startDate(LocalDate.parse("2020-08-17"))
                             .endDate(LocalDate.parse("2020-08-24"))
                             .rentalCar(testRentalCar)
                             .renter(testRenter)
                             .build();
        testBooking1.setFees();

        Booking testBooking2 = Booking.builder()
                             .reservationId(2)
                             .startDate(LocalDate.parse("2020-08-16"))
                             .endDate(LocalDate.parse("2020-08-21"))
                             .rentalCar(testRentalCar)
                             .renter(testRenter)
                             .build();
        testBooking2.setFees();

        testBookingServiceImp.addNewBooking(testBooking1);
        testBookingServiceImp.addNewBooking(testBooking2);

        assertThat(testBookingServiceImp.cancelBooking(1)).isTrue();
        assertThat(testBookingServiceImp.getBookingById(1)).isNull();
        assertThat(testBookingServiceImp.getBookingById(2)).isNotNull();

    }
}