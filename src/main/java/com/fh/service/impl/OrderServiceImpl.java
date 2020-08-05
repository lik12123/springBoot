package com.fh.service.impl;

import com.fh.dao.OrderDao;
import com.fh.entity.Order;
import com.fh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {

        order.setCreateDate(new Date());
        orderDao.addOrder(order);
    }
}
