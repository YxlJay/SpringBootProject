package com.yxl.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxl.application.entity.Admins;
import com.yxl.application.service.AdminsService;
import com.yxl.application.mapper.AdminsMapper;
import org.springframework.stereotype.Service;

/**
* @author Jay
* @description 针对表【admins】的数据库操作Service实现
* @createDate 2023-05-09 20:47:04
*/
@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins>
    implements AdminsService{

}




