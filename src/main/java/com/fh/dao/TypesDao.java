package com.fh.dao;

import com.fh.entity.Types;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypesDao{

    List<Types> queryTypesList();
}
