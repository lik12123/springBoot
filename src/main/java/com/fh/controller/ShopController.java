package com.fh.controller;

import com.fh.entity.Shop;
import com.fh.service.ShopService;
import com.fh.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shopController")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping("queryShopBySales")
    public JsonData queryShopBySales(){
        List<Shop> shops = shopService.queryShopBySales();
        return JsonData.getJsonDataSuccess(shops);
    }

    @RequestMapping("queryShopList")
    public JsonData queryShopList(){
        List<Shop> shopList = shopService.queryShopList();
        return JsonData.getJsonDataSuccess(shopList);
    }
}
