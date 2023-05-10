package com.yxl.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 15:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuturePo  implements Serializable {
    private String date;
    private String temperature;
    private String weather;
    private String wid;
    private String direct;
}
