package com.yxl.application.service.impl;

import com.yxl.application.entity.Product;
import com.yxl.application.mapper.ProductMapper;
import com.yxl.application.service.IProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
