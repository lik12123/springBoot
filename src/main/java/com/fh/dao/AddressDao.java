package com.fh.dao;

import com.fh.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressDao {

    void addAddress(Address address);

    List<Address> queryAddressListByVipName(String vipName);

    List<Address> queryAddressList();

    void updateAddressById(Address address);
}
