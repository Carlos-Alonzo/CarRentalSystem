package com.carrental.service.contract;

import com.carrental.domain.car.RentalCar;

public interface RentalCarServiceFunctions
{
    RentalCar getRentalCarById(long rentalCarId);
    boolean addNewRentalCar(RentalCar rentalCar);
    boolean removeRentalCar(long rentalCarId);

}
