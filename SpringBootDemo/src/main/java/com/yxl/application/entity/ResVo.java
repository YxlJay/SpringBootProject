package com.yxl.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 15:06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResVo implements Serializable {
    private String reason;
    private String result;
    private Integer error_code;


}
