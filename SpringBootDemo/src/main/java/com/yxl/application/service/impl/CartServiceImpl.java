package com.yxl.application.service.impl;

import com.yxl.application.entity.Cart;
import com.yxl.application.mapper.CartMapper;
import com.yxl.application.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxl
 * @since 2023-05-10
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}
