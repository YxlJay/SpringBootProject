package com.yxl.application.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 11:48
 **/
@Configuration
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class ALiConfig {
    private  String accesskey;
    private  String accesssecret;
    private  String endpoint;
    private  String bucket;

}
