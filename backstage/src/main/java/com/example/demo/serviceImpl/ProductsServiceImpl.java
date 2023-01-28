package com.example.demo.serviceImpl;

import com.example.demo.entity.Products;
import com.example.demo.mapper.ProductsMapper;
import com.example.demo.service.ProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auguste
 * @since 2022-01-27
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

}
