package com.fh.controller;

import com.alibaba.fastjson.JSONObject;
import com.fh.service.CartService;
import com.fh.util.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "购物车接口")
@RequestMapping("cartController")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("addCart")
    @ApiOperation("添加购物车的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商品id", required = true),
            @ApiImplicitParam(name = "countShop", value = "购买数量", required = true)
    }
    )
    public JsonData addCart(Integer shopId,Integer countShop){

        Long aLong = cartService.addShopCartById(shopId, countShop);
        return JsonData.getJsonDataSuccess(aLong);
    }

    @RequestMapping("queryCart")
    public JsonData queryCart(){
        List<String> strings = cartService.queryCart();
        String jsonString = JSONObject.toJSONString(strings);
        return JsonData.getJsonDataSuccess(jsonString);
    }

    @RequestMapping("deleteCart")
    public JsonData deleteCart(Integer carId){
        cartService.deleteCart(carId);
        return JsonData.getJsonDataSuccess("删除成功");
    }

    @RequestMapping("checkStates")
    public JsonData checkStates(Integer carId){
        if (carId != null){
            cartService.checkStates(carId);
        }
        return JsonData.getJsonDataSuccess("成功");
    }
}
