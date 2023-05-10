package com.yxl.application.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 14:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type implements Serializable {
    private Integer id;
    private String name;
}
