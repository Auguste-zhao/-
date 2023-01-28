package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Products;
import com.example.demo.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * <p>
 * 仓库控制器
 *
 * @author auguste
 * @since 2022-01-23
 */
@RestController
@RequestMapping("/warehouse")
@CrossOrigin
public class Warehouse {

    @Autowired
    ProductsMapper productsMapper;

    /**
     * 获取全部 [上海仓库]
     *
     * @return List<Products>
     */
    @GetMapping("/shanghai")
    public List<Products> getWarehouseShanghai() {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("warehouse", "上海");
        queryWrapper.allEq(objectObjectHashMap);
        List list = productsMapper.selectList(queryWrapper);
        return list;

    }
    /**
     * 获取全部 [北京仓库]
     *
     * @return List<Products>
     */
    @GetMapping("/peking")
    public List<Products> getWarehousePeking() {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("warehouse", "北京");
        queryWrapper.allEq(objectObjectHashMap);
        List list = productsMapper.selectList(queryWrapper);
        return list;

    }
    /**
     * 获取全部 [广州仓库]
     *
     * @return List<Products>
     */
    @GetMapping("/guangzhou")
    public List<Products> getWarehouseGuangzhou() {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("warehouse", "广州");
        queryWrapper.allEq(objectObjectHashMap);
        List list = productsMapper.selectList(queryWrapper);
        return list;

    }
    /**
     * 获取全部 [重庆仓库]
     *
     * @return List<Products>
     */
    @GetMapping("/chongqing")
    public List<Products> getWarehouseChongqing() {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("warehouse", "重庆");
        queryWrapper.allEq(objectObjectHashMap);
        List list = productsMapper.selectList(queryWrapper);
        return list;

    }

}
