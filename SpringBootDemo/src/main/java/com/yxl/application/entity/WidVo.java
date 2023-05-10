package com.yxl.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 15:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WidVo implements Serializable {
    private String day;
    private String night;

}
