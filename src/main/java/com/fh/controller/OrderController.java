package com.fh.controller;

import com.fh.service.OrderService;
import com.fh.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orderController")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("addOrder")
    public JsonData addOrder(){

        orderService.addOrder();
        return JsonData.getJsonDataSuccess("生成订单成功");
    }
}
