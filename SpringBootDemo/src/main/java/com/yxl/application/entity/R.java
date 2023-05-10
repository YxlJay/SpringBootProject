package com.yxl.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 14:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    private Integer code;
    private T data;
}
