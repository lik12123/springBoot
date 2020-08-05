package com.fh.service;

import com.fh.entity.Cart;

import java.util.List;

public interface CartService {

    Long addShopCartById(Integer shopId,Integer countShop);

    List<String> queryCart();

    void deleteCart(Integer carId);

    void checkStates(Integer carId);
}
