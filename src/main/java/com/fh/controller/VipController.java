package com.fh.controller;

import com.fh.util.JWT;
import com.fh.util.JsonData;
import com.fh.util.RedisUse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("vipController")
public class VipController {

    @RequestMapping("sendMessage")
    public JsonData sendMessage(String phoneNum){

        String code = "123456";
        RedisUse.set(phoneNum+"_lik",code,60*30);
        return JsonData.getJsonDataSuccess("成功");
    }


    @RequestMapping("login")
    public JsonData login(String phoneNum, String code, HttpServletRequest request){

        Map map = new HashMap();

        String phoneNum_lik = RedisUse.get(phoneNum + "_lik");
        if (phoneNum_lik != null && phoneNum_lik.equals(code)){

            //jwt产生的密钥
            String sign = JWT.sign(phoneNum, 1000*60 * 60 * 24);
            String encodeToString = Base64.getEncoder().encodeToString((phoneNum + "," + sign).getBytes());
            RedisUse.set("token",sign,60*30);
            map.put("message","登录成功");
            map.put("code",200);
            map.put("token",encodeToString);
        }else {
            map.put("code",500);
            map.put("message","当前用户不存在或验证码错误");
        }
        return JsonData.getJsonDataSuccess(map);
    }


}
