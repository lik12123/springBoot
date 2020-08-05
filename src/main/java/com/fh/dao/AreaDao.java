package com.fh.dao;

import com.fh.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AreaDao{

    List<Area> queryAreaList();
}
