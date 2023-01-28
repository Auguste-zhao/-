package com.example.demo.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Auguste Zhao
 * @description: 购物车
 */
public class Cart {
    List<CartItem> items;

    /**
     * 商品数量
     */
    private Integer countNum;
    /**
     * 商品总价
     */
    private BigDecimal totalAmount;

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Integer getCountNum() {
        int count = 0;
        if (items != null && items.size() > 0) {
            for (CartItem item : items) {
                count += item.getCount();
            }
        }
        return count;
    }


    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0");
        // 计算商品总价
        if (items != null && items.size() > 0) {
            for (CartItem item : items
            ) {
                BigDecimal totalPrice = item.getTotalPrice();
                amount = amount.add(totalPrice);
            }
        }
        return amount;
    }

}
