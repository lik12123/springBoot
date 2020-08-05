package com.fh.common;

import com.fh.util.JWT;
import com.fh.util.RedisUse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getParameter("token");

        if (StringUtils.isBlank(token)){
            throw new NologinException("没有登录");
        }

        byte[] decode = Base64.getDecoder().decode(token);
        String decodeStr = new String(decode);
        String[] split = decodeStr.split(",");
        if (split.length != 2){
            throw new NologinException("没有登录");
        }

            String sign = split[1];
            String phoneNum = JWT.unsign(sign, String.class);
            if (phoneNum ==null && phoneNum==""){
                throw new NologinException("没有登录");
            }else {
                String toden_rides = RedisUse.get("token");
                if (!sign.equals(toden_rides)){
                    throw  new NologinException("验证过期，重新登录");
                }
            }


        RedisUse.set("token",sign,60*30);
        request.setAttribute("login_user",phoneNum);
        return super.preHandle(request, response, handler);
    }
}
