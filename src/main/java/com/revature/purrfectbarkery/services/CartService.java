package com.revature.purrfectbarkery.services;

import com.revature.purrfectbarkery.daos.CartDAO;
import com.revature.purrfectbarkery.models.Cart;

import java.util.List;

public class CartService {

    private final CartDAO cartDAO;

    public CartService(CartDAO cartDao) {
        this.cartDAO = cartDao;
    }

    public void saveCart(Cart cart){
        cartDAO.save(cart);
    }

    public void deleteCart(String id){
        cartDAO.deleteCart(id);
    }

    public void updateCart(Cart cart){
        cartDAO.update(cart);
    }

    public List<Cart> getAll(){
        return cartDAO.getAll();
    }

    public List<Cart> getAllCartByCartId(String users_id) {
        return cartDAO.getAllCartByUserId(users_id);
    }

    public Cart giveCartByUserId(String users_id){
        return cartDAO.getById(users_id);
    }
}
