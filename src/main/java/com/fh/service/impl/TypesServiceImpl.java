package com.fh.service.impl;

import com.fh.dao.TypesDao;
import com.fh.entity.Types;
import com.fh.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TypesServiceImpl implements TypesService {

    @Autowired
    private TypesDao typesDao;

    @Override
    public List<Types> queryTypesList() {
        List<Types> types = typesDao.queryTypesList();
        return types;
    }
}
