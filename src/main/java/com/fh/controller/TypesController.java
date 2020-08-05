package com.fh.controller;

import com.fh.entity.Types;
import com.fh.service.TypesService;
import com.fh.util.JsonData;
import com.fh.util.RedisUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("typesController")
public class TypesController {

    @Autowired
    private TypesService typesService;

    @RequestMapping("queryTypesList")
    public JsonData queryTypesList(){

        String types1 = RedisUse.get("types");
        if (types1 != null){
            return JsonData.getJsonDataSuccess(types1);
        }else {
            List<Types> types = typesService.queryTypesList();
            return JsonData.getJsonDataSuccess(types);
        }
    }
}
