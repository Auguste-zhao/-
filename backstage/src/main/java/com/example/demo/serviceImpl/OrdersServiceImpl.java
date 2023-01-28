package com.example.demo.serviceImpl;

import com.example.demo.entity.Orders;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auguste
 * @since 2022-03-22
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
