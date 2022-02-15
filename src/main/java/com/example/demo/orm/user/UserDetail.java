package com.example.demo.orm.user;

import com.example.demo.orm.zdress.Address;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class UserDetail {

    int numb;

    @OneToOne
    private Address address;

}
