package com.soccerjerseystore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.CartItem;
import com.soccerjerseystore.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository <CartItem, Long> {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartItem> findByOrder(Order order);
}
