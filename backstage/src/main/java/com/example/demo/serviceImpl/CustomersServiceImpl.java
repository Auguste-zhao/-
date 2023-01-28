package com.example.demo.serviceImpl;

import com.example.demo.entity.Customers;
import com.example.demo.mapper.CustomersMapper;
import com.example.demo.service.CustomersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auguste
 * @since 2022-02-08
 */
@Service
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements CustomersService {

}
