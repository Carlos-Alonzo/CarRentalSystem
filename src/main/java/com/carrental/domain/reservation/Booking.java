package com.carrental.domain.reservation;

import com.carrental.domain.car.RentalCar;
import com.carrental.domain.user.Renter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TreeMap;

@Builder @Getter @Setter
public class Booking
{
    private long reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    @Setter(AccessLevel.NONE) private RentalCar rentalCar;
    private Renter renter;
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @Builder.Default  private Map<String, BigDecimal> rentalFees = new TreeMap<>();

    public boolean addFee(@NotNull String feeKey, BigDecimal feeAmount)
    {
        rentalFees.put(feeKey, feeAmount);
        return rentalFees.containsKey(feeKey);
    }

    public BigDecimal getFee(@NotNull String fee)
    {
        return rentalFees.get(fee);
    }

    public boolean removeFee(@NotNull String feeKey)
    {
        rentalFees.remove(feeKey);
        return !rentalFees.containsKey(feeKey);
    }

    public boolean setFees()
    {
        boolean returnVal = false;

        if(null != startDate && null != endDate && null != rentalCar && startDate.compareTo(endDate) < 0)
        {
            long rentalDays = ChronoUnit.DAYS.between(startDate, endDate);
            returnVal = addFee("rentalFee", BigDecimal.valueOf(rentalDays * rentalCar.getDailyRate()));
        }
        return returnVal;
    }

    public Map<String, BigDecimal> getFees()     { return rentalFees;}

}
