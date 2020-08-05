package com.fh.dao;

import com.fh.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopDao{

    //热销商品
    List<Shop> queryShopBySales();

    List<Shop> queryShopList();

    Shop queryShopById(Integer shopId);
}
