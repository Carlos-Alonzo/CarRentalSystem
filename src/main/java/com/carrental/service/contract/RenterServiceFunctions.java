package com.carrental.service.contract;

import com.carrental.domain.user.Renter;

public interface RenterServiceFunctions
{
    Renter getRenterById(long renterId);
    boolean addNewRenter(Renter renter);
    boolean removeRenter(long renterId);

}
