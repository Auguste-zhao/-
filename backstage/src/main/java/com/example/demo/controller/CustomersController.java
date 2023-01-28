package com.example.demo.controller;


import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Customers;
import com.example.demo.entity.Products;
import com.example.demo.mapper.CustomersMapper;
import com.example.demo.utils.JWTUtils;
import io.swagger.models.auth.In;
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
 * @since 2022-02-08
 */
@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomersController {
    @Autowired
    CustomersMapper customersMapper;

    /**
     * 顾客登录
     * @param customers
     * @return map
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Customers customers) {
        Map<String, Object> map = new HashMap<>();
        try {
            /**
             * 验证数据库中是否存在该用户
             */
            QueryWrapper queryWrapper = new QueryWrapper();
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("username", customers.getUsername());
            objectObjectHashMap.put("password", customers.getPassword());
            queryWrapper.allEq(objectObjectHashMap);
            List list = customersMapper.selectList(queryWrapper);
            /**
             * 用户对象
             */
            Customers users = (Customers) list.get(0);
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

    /**
     * 用户Token验证
     * @param Authorization
     * @return map
     */
    @GetMapping("/verify")
    public Map<String, Object> verify(@RequestHeader("Authorization") String Authorization) {
        Map<String, Object> map = new HashMap<>();
        String token = Authorization.substring(7);
        try {
            // 获取token里面保存的id
            String tokenId = JWTUtils.getTokenId(token);
            map.put("state", true);
            map.put("msg", "请求成功！");
            return map;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "无效签名！");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token过期！");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "token算法不一致！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "无效签名！");
        }
        map.put("state", false);
        return map;
    }

    /**
     * 根据Token获取用户信息
     * @param Authorization
     * @return null
     */
    @GetMapping("/info")
    public Customers getTokenId(@RequestHeader("Authorization") String Authorization) {
        String token = Authorization.substring(7);
        try {
            // 获取token里面保存的id
            String tokenId = JWTUtils.getTokenId(token);
            Customers getUser = customersMapper.selectById(tokenId);
            return getUser;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取全部顾客
     * @return List<Customers>
     */
    @GetMapping("/list")
    public List<Customers> getProductsList() {
        List<Customers> users = customersMapper.selectList(null);
        return users;
    }

    /**
     * 根据 用户Id 删除
     * @param id
     * @return map
     */
    @DeleteMapping("/deleteById")
    public Map<String, Object> deleteCustomers(@RequestBody String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            customersMapper.deleteById(id);
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
     * 根据 管理员ID 查询
     * @param id
     * @return users
     */
    @GetMapping("/list/getCustomers")
    public Customers getCustomers(String id) {
        Customers users = customersMapper.selectById(id);
        return users;
    }
    /**
     * 根据 用户姓名 查询
     * @param username
     * @return users
     */
    @GetMapping("/list/getCustomersByName")
    public Customers getCustomersByName(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("username", username);
        queryWrapper.allEq(objectObjectHashMap);
        List list = customersMapper.selectList(queryWrapper);
        /**
         * 用户对象
         */
        Customers customers = (Customers) list.get(0);
        return customers;
    }
    /**
     * 根据表单数据修改
     * @param customers
     * @return map
     */
    @PutMapping("/list/update")
    public Map<String, Object> EditCustomers(@RequestBody Customers customers) {
        Map<String, Object> map = new HashMap<>();
        try {
            customersMapper.updateById(customers);
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
     * 根据表单信息 添加
     * @param customers
     * @return map
     */
    @PostMapping("/register")
    public Map<String, Object> AddCustomers(@RequestBody Customers customers) {
        Map<String, Object> map = new HashMap<>();
        try {
            customersMapper.insert(customers);
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
