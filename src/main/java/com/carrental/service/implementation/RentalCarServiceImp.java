package com.carrental.service.implementation;

import com.carrental.domain.car.RentalCar;
import com.carrental.domain.reservation.Booking;
import com.carrental.service.contract.RentalCarServiceFunctions;

import java.util.Map;
import java.util.TreeMap;

public class RentalCarServiceImp implements RentalCarServiceFunctions
{
    private Map<Long, RentalCar> rentals;

    public RentalCarServiceImp() {rentals = new TreeMap<>();}

    @Override
    public RentalCar getRentalCarById(long rentalCarId)
    {
        return rentals.get(rentalCarId);
    }

    @Override
    public boolean addNewRentalCar(RentalCar rentalCar)
    {
        rentals.put(rentalCar.getRentalId(), rentalCar);
        return rentals.containsKey(rentalCar.getRentalId());
    }

    @Override
    public boolean removeRentalCar(long rentalCarId)
    {
        rentals.remove(rentalCarId);
        return !rentals.containsKey(rentalCarId);
    }
}
