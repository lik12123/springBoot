package com.fh.dao;

import com.fh.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDao {

    List<Order> queryOrder();

    void addOrder(Order order);
}
