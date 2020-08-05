package com.fh.controller;

import com.fh.entity.Address;
import com.fh.service.AddressService;
import com.fh.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("addressController")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("addAddress")
    public JsonData addAddress(Address address){
        addressService.addAddress(address);
        return JsonData.getJsonDataSuccess("成功");
    }

    @RequestMapping("queryAddressList")
    public JsonData queryAddressList(){
        List<Address> addressList = addressService.queryAddressList();
        return JsonData.getJsonDataSuccess(addressList);
    }



}
