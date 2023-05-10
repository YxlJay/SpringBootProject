package com.yxl.application.config;

import com.yxl.application.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/9 16:14
 **/
//@Configuration
public class BookFilterConfig {
    @Bean
    public FilterRegistrationBean<UserFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean register=new FilterRegistrationBean();
        register.setFilter(new UserFilter());
        //添加对哪个请求进行过滤
//        register.addUrlPatterns("/users/*");
        return register;
    }
}
