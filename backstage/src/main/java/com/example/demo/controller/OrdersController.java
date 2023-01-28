package com.example.demo.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author auguste
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    OrdersMapper ordersMapper;

    /**
     * 获取全部 [商品列表]
     *
     * @return List<Orders>
     */
    @GetMapping("/list")
    public List<Orders> getOrdersList(@RequestParam("id") String id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("userId",id);
        queryWrapper.allEq(objectObjectHashMap);
        List list = ordersMapper.selectList(queryWrapper);
        return list;
    }

    /**
     * 获取全部 [orders列表]
     *
     * @return List<Orders>
     */
    @GetMapping("/listAll")
    public List<Orders> getOrdersListAll() {
        List list = ordersMapper.selectList(null);
        return list;
    }

    /**
     * 根据id获取orders
     *
     * @return List<Orders>
     */
    @GetMapping("/getlistbyid")
    public Orders getOrdersListById(@RequestParam("id") String id) {
        Orders orders = ordersMapper.selectById(id);
        return orders;
    }

    @PostMapping("/addToOrders")
    public Map<String, Object> addToOrders(@RequestBody Orders orders) {
        Map<String, Object> map = new HashMap<>();
        try {
            orders.setId(IdWorker.getTimeId());
            orders.setTime(LocalDate.now());
            orders.setRole(orders.getRole());
            orders.setUserId(orders.getUserId());
            orders.setItems(orders.getItems());
            ordersMapper.insert(orders);
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
