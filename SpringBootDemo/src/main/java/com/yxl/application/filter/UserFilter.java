package com.yxl.application.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/9 16:11
 **/
public class UserFilter  implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("user");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
