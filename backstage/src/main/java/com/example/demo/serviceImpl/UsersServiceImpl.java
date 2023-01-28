package com.example.demo.serviceImpl;

import com.example.demo.entity.Users;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auguste
 * @since 2022-01-25
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
