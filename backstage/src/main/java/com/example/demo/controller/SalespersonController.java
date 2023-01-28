package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Customers;
import com.example.demo.entity.Salesperson;
import com.example.demo.mapper.SalespersonMapper;
import com.example.demo.utils.JWTUtils;
import freemarker.core.CSSOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author auguste
 * @since 2022-02-06
 */
@RestController
@RequestMapping("/salesperson")
@CrossOrigin
public class SalespersonController {

    @Autowired
    SalespersonMapper salespersonMapper;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Salesperson salesperson) {
        Map<String, Object> map = new HashMap<>();
        try {
            /**
             * 验证数据库中是否存在该用户
             */
            QueryWrapper queryWrapper = new QueryWrapper();
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("username", salesperson.getUsername());
            objectObjectHashMap.put("password", salesperson.getPassword());
            queryWrapper.allEq(objectObjectHashMap);
            List list = salespersonMapper.selectList(queryWrapper);
            /**
             * 用户对象
             */
            Salesperson users = (Salesperson) list.get(0);
            Map<String, String> payload = new HashMap<>();
            payload.put("username", users.getUsername());
            payload.put("id", users.getId().toString());

            /**
             * 生成JWT令牌
             */
            String token = JWTUtils.getToken(payload);
            map.put("status", true);
            map.put("msg", "认证成功！");
            map.put("token", token);


        } catch (Exception e) {
            map.put("status", false);
            map.put("msg", e.getMessage());
        }
        return map;

    }

    @GetMapping("/info")
    public Salesperson getTokenId(@RequestHeader("Authorization") String Authorization) {
        String token = Authorization.substring(7);
        try {
            // 获取token里面保存的id
            String tokenId = JWTUtils.getTokenId(token);
            Salesperson getUser = salespersonMapper.selectById(tokenId);
            return getUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取全部 [销售员列表]
     *
     * @return List<Salesperson>
     */
    @GetMapping("/list")
    public List<Salesperson> getSalespersonList() {
        List<Salesperson> salespeople = salespersonMapper.selectList(null);
        return salespeople;
    }

    /**
     * 根据 销售员Id 删除商品
     *
     * @param id
     * @return map
     */
    @DeleteMapping("/list")
    public Map<String, Object> deleteSalesperson(@RequestBody String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            salespersonMapper.deleteById(id);
            map.put("status", 200);
            map.put("msg", "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 400);
            map.put("msg", "删除失败！");
        }
        return map;
    }

    /**
     * 根据 销售员ID 查询销售员
     *
     * @param id
     * @return salesperson
     */
    @GetMapping("/list/getSalesperson")
    public Salesperson getSalesperson(String id) {
        Salesperson salesperson = salespersonMapper.selectById(id);
        return salesperson;
    }

    /**
     * 根据 用户姓名 查询
     * @param username
     * @return salesperson
     */
    @GetMapping("/list/getCustomersByName")
    public Salesperson getSalesmanByName(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("username", username);
        queryWrapper.allEq(objectObjectHashMap);
        List list = salespersonMapper.selectList(queryWrapper);
        /**
         * 用户对象
         */
        Salesperson salesperson = (Salesperson) list.get(0);
        return salesperson;
    }

    /**
     * 根据 销售员ID 绩效+1
     *
     * @param id
     * @return salesperson
     */
    @GetMapping("/list/salesAdd")
    public Salesperson salesAdd(String id, Integer count) {
        Salesperson salesperson = salespersonMapper.selectById(id);
        salesperson.setSales(salesperson.getSales() + count);
        salespersonMapper.updateById(salesperson);
        return salesperson;
    }

    /**
     * 根据表单数据修改 销售员信息
     *
     * @param salesperson
     * @return map
     */
    @PutMapping("/list/update")
    public Map<String, Object> EditSalesperson(@RequestBody Salesperson salesperson) {
        Map<String, Object> map = new HashMap<>();
        try {
            salespersonMapper.updateById(salesperson);
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
     * 根据表单信息 添加销售员信息
     *
     * @param salesperson
     * @return map
     */
    @PostMapping("/list")
    public Map<String, Object> AddSalesperson(@RequestBody Salesperson salesperson) {
        Map<String, Object> map = new HashMap<>();
        try {
            salespersonMapper.insert(salesperson);
            map.put("status", 200);
            map.put("msg", "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 400);
            map.put("msg", "修改失败！");
        }
        return map;
    }
}
