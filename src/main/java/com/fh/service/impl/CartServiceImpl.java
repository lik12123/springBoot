package com.fh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.dao.CartDao;
import com.fh.dao.ShopDao;
import com.fh.entity.Cart;
import com.fh.entity.Shop;
import com.fh.service.CartService;
import com.fh.util.RedisUse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ShopDao shopDao;

    @Override
    public Long addShopCartById(Integer shopId,Integer countShop) {

        String user_login = (String) request.getAttribute("login_user");

        if (countShop>0){
            Shop shop = shopDao.queryShopById(shopId);
            if (shop.getShopCount()<countShop){
                return (long) shop.getShopCount()-countShop;
            }
        }


        String hget = RedisUse.hget("cart_" + user_login + "_lik", shopId + "");
        if (StringUtils.isBlank(hget)){
            Cart cart = cartDao.queryShopCartById(shopId);
            cart.setCheck(true);
            cart.setCount(countShop);
            cart.setMoney(cart.getPrice().multiply(new BigDecimal(countShop)));
            String jsonString = JSONObject.toJSONString(cart);
            RedisUse.hset("cart_" + user_login + "_lik",shopId+"",jsonString);
        }else {
            Cart cart = JSONObject.parseObject(hget, Cart.class);


            Shop shop = shopDao.queryShopById(shopId);
            if (shop.getShopCount()<cart.getCount()){
                return (long)shop.getShopCount()-cart.getCount();
            }
            cart.setCount(cart.getCount()+countShop);
            //小计
            cart.setMoney(cart.getPrice().multiply(new BigDecimal(cart.getCount())));
            String jsonString = JSONObject.toJSONString(cart);
            RedisUse.hset("cart_" + user_login + "_lik",shopId+"",jsonString);
        }

        Long hlen = RedisUse.hlen("cart_" + user_login + "_lik");
        return hlen;
    }

    @Override
    public List<String> queryCart() {
        String phoneNum = (String) request.getAttribute("login_user");
        List<String> carList = RedisUse.hgetAll("cart_"+phoneNum+"_lik");
        return carList;
    }

    @Override
    public void deleteCart(Integer carId) {
        String phoneNum = (String) request.getAttribute("login_user");
        RedisUse.hdel("cart_"+phoneNum+"_lik",carId+"");
    }

    @Override
    public void checkStates(Integer carId) {
        String phoneNum = (String) request.getAttribute("login_user");
        String hget = RedisUse.hget("cart_" + phoneNum + "_lik", carId + "");
        Cart cart = JSONObject.parseObject(hget,Cart.class);
        if (cart.isCheck()==true){
            cart.setCheck(false);
        }else {
            cart.setCheck(true);
        }
        String jsonString = JSON.toJSONString(cart);
        RedisUse.hset("cart_" + phoneNum + "_lik", carId + "",jsonString);
    }
}
