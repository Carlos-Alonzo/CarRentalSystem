package com.carrental.service.implementation;

import com.carrental.domain.car.CarType;
import com.carrental.domain.car.RentalCar;
import com.carrental.domain.car.RentalClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RentalCarServiceImpTest
{
    RentalCarServiceImp testRentalCarServiceImp;
    RentalCar testRentalCar;

    @BeforeEach
    void setUp()
    {
        testRentalCarServiceImp = new RentalCarServiceImp();

        testRentalCar = new RentalCar();
        testRentalCar.setRentalClass(RentalClassTypes.VAN);
        testRentalCar.setRentalId(1l);
        testRentalCar.setDailyRate(29);
        testRentalCar.setVIN("YHNF345690890");
        testRentalCar.setMake("Toyota");
        testRentalCar.setModel("Sienna");
        testRentalCar.setYear(2011);
        testRentalCar.setCarType(CarType.VAN);

    }

    @Test
    void getRentalCarById()
    {
        testRentalCarServiceImp.addNewRentalCar(testRentalCar);

        assertThat(testRentalCarServiceImp.getRentalCarById(1l))
                .isNotNull()
                .isInstanceOf(RentalCar.class)
                .isEqualToComparingFieldByField(testRentalCar);

    }

    @Test
    void addNewRentalCar()
    {
        assertThat(testRentalCarServiceImp.addNewRentalCar(testRentalCar))
                .isTrue();

        assertThat(testRentalCarServiceImp.getRentalCarById(1l))
                .isNotNull()
                .isInstanceOf(RentalCar.class)
                .isEqualToComparingFieldByField(testRentalCar);

    }

    @Test
    void removeRentalCar()
    {
        assertThat(testRentalCarServiceImp.addNewRentalCar(testRentalCar))
                .isTrue();

        assertThat(testRentalCarServiceImp.removeRentalCar(1l)).isTrue();
        assertThat(testRentalCarServiceImp.getRentalCarById(1l)).isNull();

    }
}