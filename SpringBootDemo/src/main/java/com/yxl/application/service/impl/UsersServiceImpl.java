package com.yxl.application.service.impl;

import com.yxl.application.entity.Users;
import com.yxl.application.mapper.UsersMapper;
import com.yxl.application.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxl
 * @since 2023-05-09
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
