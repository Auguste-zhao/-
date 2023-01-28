package com.example.demo.service;

import com.example.demo.vo.Cart;
import com.example.demo.vo.CartItem;

/**
 * @author: Auguste Zhao
 * @description: CartService
 */
public interface CartService {
    /**
     * 添加商品到购物车
     *
     * @param id
     * @param itemId
     * @param num
     * @return
     */
    CartItem addToCart(String id, Long itemId, Integer num);

    /**
     * 获取整个购物车
     *
     * @return
     * @param id
     */
    Cart getCart(String id);

    /**
     * 清空购物车
     * @param cartKey
     */
    void clearCart(String cartKey);

    /**
     * 删除购物车商品
     * @param itemId
     */
    void deleteItem(String id,Long itemId);
}
