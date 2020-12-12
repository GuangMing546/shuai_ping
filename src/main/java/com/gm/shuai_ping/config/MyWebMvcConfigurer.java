package com.gm.shuai_ping.config;

import com.gm.shuai_ping.component.LoginHandleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    LoginHandleInterceptor loginHandleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //排除拦截，除了注册登录(此时还没token)，其他都拦截
        excludePath.add("/v1/userRegister");  //注册
        excludePath.add("/v1/enterpriseRegister");  //注册
        excludePath.add("/v1/test");  //注册
        excludePath.add("/v1/login");     //登录
        excludePath.add("/static/**");  //静态资源
        excludePath.add("/assets/**");  //静态资源

        registry.addInterceptor(loginHandleInterceptor).addPathPatterns("/**")
                                                        .excludePathPatterns(excludePath);
    }
}
