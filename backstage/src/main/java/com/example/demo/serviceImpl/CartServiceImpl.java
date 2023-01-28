package com.example.demo.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Products;
import com.example.demo.mapper.ProductsMapper;
import com.example.demo.service.CartService;
import com.example.demo.vo.Cart;
import com.example.demo.vo.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: Auguste Zhao
 * @description: CartServiceImpl
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    ProductsMapper productsMapper;

    // redis 数据库前缀
    private final String CART_PREFIX = "carshop:cart:";

    @Override
    public CartItem addToCart(String id, Long itemId, Integer num) {

        BoundHashOperations<String, Object, Object> cartOps = getCartOps(id, itemId, num);

        // 1、获取商品信息
        Products products = productsMapper.selectById(itemId);
        // 获取购物车中是否存在该商品
        String res = (String) cartOps.get(itemId.toString());
        if (StringUtils.isEmpty(res)) {
            CartItem cartItem = new CartItem();
            cartItem.setId(itemId);
            cartItem.setCount(1);
            cartItem.setTitle(products.getTitle());
            cartItem.setPrice(products.getPrice());
            cartItem.getTotalPrice();
            String s = JSON.toJSONString(cartItem);
            cartOps.put(itemId.toString(), s);
            return cartItem;
        } else {
            CartItem cartItem = JSON.parseObject(res, CartItem.class);
            cartItem.setCount(cartItem.getCount() + 1);
            cartOps.put(itemId.toString(), JSON.toJSONString(cartItem));
            return cartItem;
        }

    }

    /**
     * 获取整个购物车
     *
     * @param id 用户id
     * @return
     */
    @Override
    public Cart getCart(String id) {
        Cart cart = new Cart();
        // 根据用户id获取到用户购物车
        String cartKey = CART_PREFIX + id;
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);
        List<CartItem> cartItems = getCartItems(cartKey);
        cart.setItems(cartItems);
        return cart;
    }

    /**
     * 获取到要操作的数据库
     *
     * @param id
     * @param itemId
     * @param num
     * @return options
     */
    private BoundHashOperations<String, Object, Object> getCartOps(String id, Long itemId, Integer num) {
        String cartKey = "";
        cartKey = CART_PREFIX + id;

        // 打印 当前用户id 当前商品id 商品数量
//        System.out.println(id + "----" + itemId + "----" + num);
        // 操作redis
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);
        return operations;
    }

    /**
     * 获取购物车数据
     *
     * @param cartKey
     * @return
     */
    private List<CartItem> getCartItems(String cartKey) {
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);
        List<Object> values = operations.values();
        if (values != null && values.size() > 0) {
            List<CartItem> collect = values.stream().map((obj) -> {
                String string = (String) obj;
                CartItem cartItem = JSON.parseObject(string, CartItem.class);
                return cartItem;
            }).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    @Override
    public void clearCart(String cartKey) {
        redisTemplate.delete(cartKey);
    }

    @Override
    public void deleteItem(String id,Long itemId) {
        String cartKey = "";
        cartKey = CART_PREFIX + id;
        // 操作redis
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);
        operations.delete(itemId.toString());
    }

}
