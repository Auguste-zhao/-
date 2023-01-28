package com.example.demo.serviceImpl;

import com.example.demo.entity.Salesperson;
import com.example.demo.mapper.SalespersonMapper;
import com.example.demo.service.SalespersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auguste
 * @since 2022-02-06
 */
@Service
public class SalespersonServiceImpl extends ServiceImpl<SalespersonMapper, Salesperson> implements SalespersonService {

}
