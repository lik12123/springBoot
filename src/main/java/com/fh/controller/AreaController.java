package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.entity.Area;
import com.fh.service.AreaService;
import com.fh.util.JsonData;
import com.fh.util.RedisUse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "地区管理相关接口")
@RequestMapping("areaController")
public class AreaController {

    @Autowired
    private AreaService areaService;


    @RequestMapping("queryAreaList")
    @ApiOperation("查询地区的接口")
    public JsonData queryAreaList(){
//        String area = RedisUse.get("area");
//        if (area != null && area !=""){
//            return JsonData.getJsonDataSuccess(area);
//        }else {
            List<Area> areas = areaService.queryAreaList();
            return JsonData.getJsonDataSuccess(areas);
//        }
    }
}
