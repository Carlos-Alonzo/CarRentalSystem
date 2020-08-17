package com.carrental.domain.car;

import lombok.*;

@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class BaseCar
{
    @NonNull private String VIN;
    @NonNull private String make;
    @NonNull private String model;
    private int year;
    @NonNull private CarType carType;
}
