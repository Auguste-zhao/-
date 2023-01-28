package com.example.demo.controller;


import com.example.demo.entity.Announcement;
import com.example.demo.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author auguste
 * @since 2022-01-31
 */
@RestController
@RequestMapping("/announcement")
@CrossOrigin
public class AnnouncementController {

    @Autowired
    AnnouncementMapper announcementMapper;

    /**
     * 获取全部 [公告列表]
     * @return List<Announcement>
     */
    @GetMapping("/list")
    public List<Announcement> getAnnouncement() {
        List<Announcement> announcements = announcementMapper.selectList(null);
        return announcements;
    }

    /**
     * 根据表单信息 添加公告
     * @param announcement
     * @return map
     */
    @PostMapping("/list")
    public Map<String, Object> AddAnnouncements(@RequestBody Announcement announcement) {
        Map<String, Object> map = new HashMap<>();
        try {
            announcementMapper.insert(announcement);
            map.put("status", 200);
            map.put("msg", "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 400);
            map.put("msg", "修改失败！");
        }
        return map;
    }

    /**
     * 根据 商品Id 删除公告
     * @param id
     * @return map
     */
    @DeleteMapping("/list")
    public Map<String, Object> deleteAnnouncement(@RequestBody String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            announcementMapper.deleteById(id);
            map.put("status", 200);
            map.put("msg", "删除成功！");
            map.put("id",id);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 400);
            map.put("msg", "删除失败！");
        }
        return map;
    }

}
