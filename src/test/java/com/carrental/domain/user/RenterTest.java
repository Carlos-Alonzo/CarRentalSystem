package com.carrental.domain.user;

import com.carrental.domain.address.Address;
import com.carrental.domain.car.CarType;
import com.carrental.domain.car.RentalCar;
import com.carrental.domain.car.RentalClassTypes;
import com.carrental.domain.reservation.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class RenterTest
{
    Renter testRenter;
    Address testAddress;
    RentalCar testRentalCar;
    Booking testBooking;

    @BeforeEach
    void setUp()
    {
        testRenter = new Renter();
        testRenter.setRenterId(1l);
        testRenter.setFirstName("Charles");
        testRenter.setLastName("River");
        testRenter.setEmail("jonas@docker.com");
        testRenter.setPwd("12345678");

        testAddress = Address.builder().address1("25 Elliot Drive").city("Chelsea").state("MA").zipCode("01849").country("USA").build();
        testRenter.setResidentialAddress(testAddress);
        testRenter.setBillingAddress(testAddress);
        testRenter.setMailingAddress(testAddress);

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

    }

    @Test
    public void RenterClassTest()
    {
        assertThat(testRenter)
                .hasFieldOrPropertyWithValue("renterId", 1l)
                .hasFieldOrPropertyWithValue("firstName", "Charles")
                .hasFieldOrPropertyWithValue("lastName", "River")
                .hasFieldOrPropertyWithValue("email", "jonas@docker.com")
                .hasFieldOrPropertyWithValue("pwd", "12345678");

    }

    @Test
    void RenterAddressTest()
    {
        assertThat(testRenter.getBillingAddress())
                .hasFieldOrPropertyWithValue("address1", "25 Elliot Drive")
                .hasFieldOrPropertyWithValue("city", "Chelsea")
                .hasFieldOrPropertyWithValue("state", "MA")
                .hasFieldOrPropertyWithValue("zipCode", "01849")
                .hasFieldOrPropertyWithValue("country", "USA");

        assertThat(testRenter.getResidentialAddress())
                .hasFieldOrPropertyWithValue("address1", "25 Elliot Drive")
                .hasFieldOrPropertyWithValue("city", "Chelsea")
                .hasFieldOrPropertyWithValue("state", "MA")
                .hasFieldOrPropertyWithValue("zipCode", "01849")
                .hasFieldOrPropertyWithValue("country", "USA");

        assertThat(testRenter.getMailingAddress())
                .hasFieldOrPropertyWithValue("address1", "25 Elliot Drive")
                .hasFieldOrPropertyWithValue("city", "Chelsea")
                .hasFieldOrPropertyWithValue("state", "MA")
                .hasFieldOrPropertyWithValue("zipCode", "01849")
                .hasFieldOrPropertyWithValue("country", "USA");
    }

    @Test
    void addBookingTest()
    {
        assertThat(testRenter.addBooking(testBooking)).isTrue();
    }

    @Test
    void removeBookingTest()
    {
        testRenter.addBooking(testBooking);
        assertThat(testRenter.removeBooking(testBooking)).isTrue();
    }
}