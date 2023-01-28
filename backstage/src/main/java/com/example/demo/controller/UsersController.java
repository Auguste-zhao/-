package com.example.demo.controller;


import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Users;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 * <p>
 * 用户控制器
 *
 * @author auguste
 * @since 2022-01-23
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UsersController {

    @Autowired
    UsersMapper usersMapper;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;  //注入bcryct加密

    /**
     * 用户登录
     *
     * @param user
     * @return map
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Users user) {
        Map<String, Object> map = new HashMap<>();
        try {
            /**
             * 验证数据库中是否存在该用户
             */
            QueryWrapper queryWrapper = new QueryWrapper();
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("username", user.getUsername());
            queryWrapper.allEq(objectObjectHashMap);
            List list = usersMapper.selectList(queryWrapper);
            /**
             * 用户对象
             */
            Users users = (Users) list.get(0);
            if (bCryptPasswordEncoder.matches(user.getPassword(), users.getPassword())) {
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
            }else {
                System.out.println("error");
            }

        } catch (Exception e) {
            map.put("status", false);
            map.put("msg", e.getMessage());
        }
        return map;

    }

    /**
     * 用户Token验证
     *
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
     *
     * @param Authorization
     * @return null
     */
    @GetMapping("/info")
    public Users getTokenId(@RequestHeader("Authorization") String Authorization) {
        String token = Authorization.substring(7);
        try {
            // 获取token里面保存的id
            String tokenId = JWTUtils.getTokenId(token);
            Users getUser = usersMapper.selectById(tokenId);
            return getUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取全部 [管理员列表]
     *
     * @return List<Users>
     */
    @GetMapping("/list")
    public List<Users> getProductsList() {
        List<Users> users = usersMapper.selectList(null);
        return users;
    }

    /**
     * 根据 管理员Id 删除商品
     *
     * @param id
     * @return map
     */
    @DeleteMapping("/list")
    public Map<String, Object> deleteProducts(@RequestBody String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            usersMapper.deleteById(id);
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
     * 根据 管理员ID 查询商品
     *
     * @param id
     * @return users
     */
    @GetMapping("/list/getAdmin")
    public Users getProducts(String id) {
        Users users = usersMapper.selectById(id);
        return users;
    }

    /**
     * 根据表单数据修改 管理员信息
     *
     * @param user
     * @return map
     */
    @PutMapping("/list/update")
    public Map<String, Object> EditProducts(@RequestBody Users user) {
        Map<String, Object> map = new HashMap<>();
        try {
            Users newUsers = new Users();
            // 加密密码并重新封装
            newUsers.setId(user.getId());
            newUsers.setUsername(user.getUsername());
            if (user.getPassword() != null){
                String newPassword = bCryptPasswordEncoder.encode(user.getPassword());
                System.out.println(newPassword);
                newUsers.setPassword(newPassword);
            }
            newUsers.setRole(user.getRole());
            newUsers.setPosition(user.getPosition());
            newUsers.setTel(user.getTel());
            usersMapper.updateById(newUsers);
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
     * 根据表单信息 添加管理员信息
     *
     * @param user
     * @return map
     */
    @PostMapping("/list")
    public Map<String, Object> AddProducts(@RequestBody Users user) {
        Map<String, Object> map = new HashMap<>();
        try {
            Users newUsers = new Users();
            // 加密密码并重新封装
            newUsers.setId(user.getId());
            newUsers.setUsername(user.getUsername());
            String newPassword = bCryptPasswordEncoder.encode(user.getPassword());
            newUsers.setPassword(newPassword);
            newUsers.setRole(user.getRole());
            newUsers.setPosition(user.getPosition());
            newUsers.setTel(user.getTel());
            usersMapper.insert(newUsers);
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
