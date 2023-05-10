package com.yxl.application.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/9 19:17
 **/
@Configuration
@ConfigurationProperties("myconfig")
@Data
public class MyConfig {
private String username;

public void send(){
    System.out.println(username);

}
}
