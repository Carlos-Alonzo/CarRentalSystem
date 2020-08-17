package com.carrental.domain.reservation;

import com.carrental.domain.address.Address;
import com.carrental.domain.car.CarType;
import com.carrental.domain.car.RentalCar;
import com.carrental.domain.car.RentalClassTypes;
import com.carrental.domain.user.Renter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class BookingTest
{
    Booking testBooking;
    Renter testRenter;
    Address testAddress;
    RentalCar testRentalCar;

    @BeforeEach
    void setUp() throws ParseException
    {
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

    }

    @Test
    public void bookingTest()
    {
        assertThat(testBooking).isInstanceOf(Booking.class)
                               .isNotNull()
                               .hasNoNullFieldsOrProperties()
                               .hasFieldOrPropertyWithValue("rentalCar", testRentalCar)
                               .hasFieldOrPropertyWithValue("renter", testRenter)
                               .hasFieldOrProperty("rentalFees")
                               .hasFieldOrPropertyWithValue("startDate", LocalDate.parse("2020-08-17"))
                               .hasFieldOrPropertyWithValue("endDate", LocalDate.parse("2020-08-24"))
                               .hasFieldOrPropertyWithValue("reservationId", 1l);

        assertThat(testBooking.getFees()).containsExactly(entry("rentalFee", BigDecimal.valueOf(343)));

        testBooking.addFee("tax", BigDecimal.valueOf(23.45));
        assertThat(testBooking.getFee("tax")).isEqualTo(BigDecimal.valueOf(23.45));

        Map<String, BigDecimal> expected = testBooking.getFees();
        assertThat(expected).containsExactly(entry("rentalFee", BigDecimal.valueOf(343)), entry("tax", BigDecimal.valueOf(23.45)));

        testBooking.removeFee("tax");
        assertThat(testBooking.getFees()).doesNotContain(entry("tax", BigDecimal.valueOf(23.45)));

    }
}