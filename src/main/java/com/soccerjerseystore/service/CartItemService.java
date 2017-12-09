package com.soccerjerseystore.service;

import java.util.List;

import com.soccerjerseystore.domain.CartItem;
import com.soccerjerseystore.domain.Jersey;
import com.soccerjerseystore.domain.ShoppingCart;
import com.soccerjerseystore.domain.User;

public interface CartItemService {
	CartItem addJerseyToCartItem(Jersey jersey, User user, int qty);
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartITem> findByOrder(Order order);
	
	CartItem updateCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem findById(Long id);
	
	CartItem save(CartItem cartItem);
}
