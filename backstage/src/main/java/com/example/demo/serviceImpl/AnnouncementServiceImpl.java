package com.example.demo.serviceImpl;

import com.example.demo.entity.Announcement;
import com.example.demo.mapper.AnnouncementMapper;
import com.example.demo.service.AnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auguste
 * @since 2022-01-31
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

}
