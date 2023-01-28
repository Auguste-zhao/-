package com.example.demo.vo;

import java.math.BigDecimal;

/**
 * @author: Auguste Zhao
 * @description: 购物项
 */
public class CartItem {
    private Long id;
    private String title;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 计算总价
     */
    public BigDecimal getTotalPrice() {
        return this.price.multiply(new BigDecimal(("" + this.count)));
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
