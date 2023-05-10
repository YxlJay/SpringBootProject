package com.yxl.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 15:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Realtime implements Serializable {
    private String wid;
    private String temperature;
    private String direct;
    private String aqi;
    private String humidity;
    private String power;
    private String info;

}
