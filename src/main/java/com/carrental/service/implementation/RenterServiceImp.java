package com.carrental.service.implementation;

import com.carrental.domain.user.Renter;
import com.carrental.service.contract.RenterServiceFunctions;
import java.util.Map;
import java.util.TreeMap;

public class RenterServiceImp implements RenterServiceFunctions
{
    private Map<Long, Renter> renters;

    public RenterServiceImp() { renters = new TreeMap<>();}

    @Override
    public Renter getRenterById(long renterId)
    {
        return renters.get(renterId);
    }

    @Override
    public boolean addNewRenter(Renter renter)
    {
        renters.put(renter.getRenterId(), renter);
        return renters.containsKey(renter.getRenterId());
    }

    @Override
    public boolean removeRenter(long renterId)
    {
        renters.remove(renterId);
        return !renters.containsKey(renterId);
    }
}
