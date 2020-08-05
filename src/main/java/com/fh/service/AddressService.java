package com.fh.service;

import com.fh.entity.Address;

import java.util.List;

public interface AddressService {


    void addAddress(Address address);

    List<Address> queryAddressList();
}
