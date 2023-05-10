package com.yxl.application.util;

import java.util.UUID;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/3/5 14:46
 **/
public class FileUtil1 {
    public  static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getNewFileName(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
