package com.soccerjerseystore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccerjerseystore.domain.CartItem;
import com.soccerjerseystore.domain.Jersey;
import com.soccerjerseystore.domain.JerseyToCartItem;
import com.soccerjerseystore.domain.ShoppingCart;
import com.soccerjerseystore.domain.User;
import com.soccerjerseystore.repository.CartItemRepository;
import com.soccerjerseystore.repository.JerseyToCartItemRepository;
import com.soccerjerseystore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private JerseyToCartItemRepository jerseyToCartItemRepository;
	
	public CartItem addJerseyToCartItem(Jersey jersey, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for(CartItem cartItem : cartItemList) {
			if(jersey.getId() == cartItem.getJersey().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(jersey.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		};
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setJersey(jersey);
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(jersey.getOurPrice()).multiply(new BigDecimal(qty)));
		
		cartItem = cartItemRepository.save(cartItem);
		
		JerseyToCartItem jerseyToCartItem = new JerseyToCartItem();
		jerseyToCartItem.setJersey(jersey);
		jerseyToCartItem.setCartItem(cartItem);
		jerseyToCartItemRepository.save(jerseyToCartItem);
		
		return cartItem;
	}
	
	@Transactional
	public void removeCartItem(CartItem cartItem) {
		jerseyToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
	}
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getJersey().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}
	
	public CartItem findById(Long id) {
		return cartItemRepository.findOne(id);
	}
	
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
	
//	public List<CartItem> findByOrder(Order order) {
//		return cartItemRepository.findByOrder(order);
//	}
}
