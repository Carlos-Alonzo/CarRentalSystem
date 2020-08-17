package com.carrental.domain.car;

import lombok.*;


@ToString @EqualsAndHashCode @Getter @Setter
public class RentalCar extends BaseCar
{
    private long rentalId;
    private int dailyRate;
    private RentalClassTypes rentalClass;

    public RentalCar() {super();}

}
