package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Products;
import com.example.demo.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 * <p>
 * 商品控制器
 *
 * @author auguste
 * @since 2022-01-23
 */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductsController {

    @Autowired
    ProductsMapper productsMapper;

    /**
     * 获取全部 [商品列表]
     *
     * @return List<Products>
     */
    @GetMapping("/list")
    public List<Products> getProductsList() {
        List<Products> products = productsMapper.selectList(null);
        return products;
    }

    /**
     * 根据 商品Id 删除商品
     *
     * @param id
     * @return map
     */
    @DeleteMapping("/list")
    public Map<String, Object> deleteProducts(@RequestBody String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            productsMapper.deleteById(id);
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
     * 根据 商品ID 查询商品
     *
     * @param id
     * @return products
     */
    @GetMapping("/list/getProduct")
    public Products getProducts(String id) {
        Products products = productsMapper.selectById(id);
        return products;
    }

    /**
     * 根据 商品ID 减少商品数量
     *
     * @param id
     * @return products
     */
    @GetMapping("/list/reduceProduct")
    public Products reduceProduct(String id, Integer count) {
        Products products = productsMapper.selectById(id);
        if (products.getSurplus() > 0 && count < products.getSurplus()) {
            products.setSurplus(products.getSurplus() - count);
            productsMapper.updateById(products);
        }
        return products;
    }

    /**
     * 根据 商品名 模糊查询商品
     *
     * @param title
     * @return products
     */
    @GetMapping("/list/getProductByName")
    public List<Products> getProductsByName(String title) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(true, "title", title);
        List list = productsMapper.selectList(queryWrapper);

        return list;
    }

    /**
     * 推荐算法的 模糊查询
     *
     * @param title
     * @return products
     */
    @GetMapping("/list/getAdviceProducts")
    public List<Products> getAdviceProducts(String title) {
        int length = title.length();
        String newTitle = title.substring(length - 2);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(true, "title", newTitle);
        List list = productsMapper.selectList(queryWrapper);

        return list;
    }

    /**
     * 根据表单数据修改 商品信息
     *
     * @param products
     * @return map
     */
    @PutMapping("/list/update")
    public Map<String, Object> EditProducts(@RequestBody Products products) {
        Map<String, Object> map = new HashMap<>();
        try {
            productsMapper.updateById(products);
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
     * 根据表单信息 添加商品信息
     *
     * @param products
     * @return map
     */
    @PostMapping("/list")
    public Map<String, Object> AddProducts(@RequestBody Products products) {
        Map<String, Object> map = new HashMap<>();
        try {
            productsMapper.insert(products);
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
