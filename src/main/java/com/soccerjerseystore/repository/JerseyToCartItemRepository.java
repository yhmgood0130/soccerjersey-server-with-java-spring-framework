package com.soccerjerseystore.repository;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.CartItem;
import com.soccerjerseystore.domain.JerseyToCartItem;

public interface JerseyToCartItemRepository extends CrudRepository<JerseyToCartItem, Long>{
	void deleteByCartItem(CartItem cartItem);
}
