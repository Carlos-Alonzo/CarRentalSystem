package com.carrental.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RentalCarTest
{

    RentalCar testRentalCar;

    @BeforeEach
    void setUp()
    {
        testRentalCar = new RentalCar();
        testRentalCar.setRentalClass(RentalClassTypes.COMPACT);
        testRentalCar.setRentalId(1l);
        testRentalCar.setDailyRate(19);
        testRentalCar.setVIN("YHNF345690890");
        testRentalCar.setMake("Toyota");
        testRentalCar.setModel("Sienna");
        testRentalCar.setYear(1992);
        testRentalCar.setCarType(CarType.VAN);

    }

    @Test
    public void RentalCarTest()
    {
    assertThat(testRentalCar).isInstanceOf(RentalCar.class);
    assertThat(testRentalCar.getRentalId()).isEqualTo(1);
    assertThat(testRentalCar.getRentalClass()).isEqualTo(RentalClassTypes.COMPACT);
    assertThat(testRentalCar.getDailyRate()).isEqualTo(19);
    assertThat(testRentalCar.getVIN()).isEqualTo("YHNF345690890");
    assertThat(testRentalCar.getMake()).isEqualTo("Toyota");
    assertThat(testRentalCar.getModel()).isEqualTo("Sienna");
    assertThat(testRentalCar.getYear()).isEqualTo(1992);
    assertThat(testRentalCar.getCarType()).isEqualTo(CarType.VAN);

    }
}