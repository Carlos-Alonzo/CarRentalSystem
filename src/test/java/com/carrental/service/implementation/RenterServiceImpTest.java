package com.carrental.service.implementation;

import com.carrental.domain.address.Address;
import com.carrental.domain.user.Renter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RenterServiceImpTest
{
    Renter testRenter1;
    RenterServiceImp testRenterServiceImp;
    Address testAddress;
    
    @BeforeEach
    void setUp()
    {
        testRenterServiceImp = new RenterServiceImp();
        
        testRenter1 = new Renter();
        testRenter1.setRenterId(1l);
        testRenter1.setFirstName("Charles");
        testRenter1.setLastName("River");
        testRenter1.setEmail("jonas@docker.com");
        testRenter1.setPwd("12345678");

        testAddress = Address.builder().address1("25 Elliot Drive").city("Chelsea").state("MA").zipCode("01849").country("USA").build();
        testRenter1.setResidentialAddress(testAddress);
        testRenter1.setBillingAddress(testAddress);
        testRenter1.setMailingAddress(testAddress);
    }

    @Test
    void getRenterById()
    {
        testRenterServiceImp.addNewRenter(testRenter1);
        assertThat(testRenterServiceImp.getRenterById(1l))
                .isNotNull()
                .isInstanceOf(Renter.class)
                .isEqualToComparingFieldByField(testRenter1);
    }

    @Test
    void addNewRenter()
    {
        assertThat(testRenterServiceImp.addNewRenter(testRenter1)).isTrue();
        assertThat(testRenterServiceImp.getRenterById(1l))
                .isNotNull()
                .isInstanceOf(Renter.class)
                .isEqualToComparingFieldByField(testRenter1);
    }

    @Test
    void removeRenter()
    {
        testRenterServiceImp.addNewRenter(testRenter1);
        assertThat(testRenterServiceImp.removeRenter(1l)).isTrue();
        assertThat(testRenterServiceImp.getRenterById(1l)).isNull();
    }
}