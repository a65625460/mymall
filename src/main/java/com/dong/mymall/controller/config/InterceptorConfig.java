package com.dong.mymall.controller.config;

import com.dong.mymall.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建拦截器对象
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        // 注册拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        // 设置拦截对象
        interceptorRegistration.addPathPatterns();
    }
}
