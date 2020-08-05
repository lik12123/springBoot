package com.fh.service;

import com.fh.entity.Shop;

import java.util.List;

public interface ShopService  {

    //热销商品
    List<Shop> queryShopBySales();

    List<Shop> queryShopList();
}
