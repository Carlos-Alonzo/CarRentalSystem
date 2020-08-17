package com.carrental.domain.user;

import com.carrental.domain.address.Address;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class BaseUser
{
    private String firstName;
    private String lastName;
    @Email private String email;
    private String pwd;
    private Address mailingAddress;
    private Address residentialAddress;
    private Address billingAddress;
}
