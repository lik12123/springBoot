package com.fh.dao;

import com.fh.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CartDao {

    Cart queryShopCartById(Integer shopId);
}
