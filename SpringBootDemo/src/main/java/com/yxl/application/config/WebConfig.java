package com.yxl.application.config;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/9 19:31
 **/

import com.yxl.application.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有访问路径，都通过MyInterceptor类型的拦截器进行拦截//放行q
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/users/**").excludePathPatterns("/users/q");


    }
}
