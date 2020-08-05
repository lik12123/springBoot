package com.fh.common;

import com.fh.common.TestInterceperConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器的配置   拦截那些东西  不拦截那些东西
@Configuration //声明是配置文件类
public class TestInterceperConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new KuaYuInterceptor());
        InterceptorRegistration registration2 = registry.addInterceptor(new LoginInterceptor());
        //addPathPatterns拦截哪些请求  excludePathPatterns不拦截哪些请求
        registration.addPathPatterns("/**");
        registration2.addPathPatterns(
                "/cartController/**",
                "/addressController/**"
        );
    }
}
