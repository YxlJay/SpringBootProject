package com.yxl.application.entity.news;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 17:16
 **/
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data implements Serializable {
    private String uniquekey;
    private String title;
    private String date;
    private String category;
    private String author_name;
    private String url;
    private String thumbnail_pic_s;
    private String is_content;
}
