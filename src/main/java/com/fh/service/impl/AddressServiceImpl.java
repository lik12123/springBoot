package com.fh.service.impl;

import com.fh.dao.AddressDao;
import com.fh.entity.Address;
import com.fh.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void addAddress(Address address) {

        String login_user = (String) request.getAttribute("login_user");

        address.setVipName(login_user);
        if (address.getIscheck() ==1){
            List<Address> addressList = addressDao.queryAddressList();

            for (int i = 0; i < addressList.size(); i++) {
                addressList.get(i).setIscheck(0);
                addressDao.updateAddressById(addressList.get(i));
            }
        }
        address.setCreateDate(new Date());
        addressDao.addAddress(address);
    }

    @Override
    public List<Address> queryAddressList() {

        String login_user = (String) request.getAttribute("login_user");
        List<Address> addresses = addressDao.queryAddressListByVipName(login_user);
        return addresses;
    }
}
