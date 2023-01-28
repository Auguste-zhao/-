package com.example.demo.controller;

import com.example.demo.service.CartService;
import com.example.demo.vo.Cart;
import com.example.demo.vo.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Auguste Zhao
 * @description: xxx
 */
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping()
    public Cart getUserId(@RequestParam("id") String id, Model model) {
        Cart cart = cartService.getCart(id);
        model.addAttribute("cart", cart);
        return cart;
    }

    /**
     * 将商品添加到购物车
     *
     * @param id
     * @param itemId
     * @param num
     * @return String
     */
    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("id") String id, @RequestParam("itemId") Long itemId, @RequestParam("num") Integer num) {
        CartItem cartItem = cartService.addToCart(id, itemId, num);
        return "success";
    }

    @GetMapping("/clearCart")
    public String cleanCart(@RequestParam("id") String id) {
        String cartKey = "";
        cartKey = "carshop:cart:" + id;
        cartService.clearCart(cartKey);
        return "success";
    }

    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam("id") String id,@RequestParam("itemId") Long itemId) {
        cartService.deleteItem(id,itemId);
        return "success";
    }
}
