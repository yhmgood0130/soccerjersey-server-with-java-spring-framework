package com.soccerjerseystore.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccerjerseystore.domain.BillingAddress;
import com.soccerjerseystore.domain.CartItem;
import com.soccerjerseystore.domain.Jersey;
import com.soccerjerseystore.domain.Order;
import com.soccerjerseystore.domain.Payment;
import com.soccerjerseystore.domain.ShippingAddress;
import com.soccerjerseystore.domain.ShoppingCart;
import com.soccerjerseystore.domain.User;
import com.soccerjerseystore.repository.BillingAddressRepository;
import com.soccerjerseystore.repository.OrderRepository;
import com.soccerjerseystore.repository.PaymentRepository;
import com.soccerjerseystore.repository.ShippingAddressRepository;
import com.soccerjerseystore.service.CartItemService;
import com.soccerjerseystore.service.JerseyService;
import com.soccerjerseystore.service.OrderService;
import com.soccerjerseystore.utility.MailConstructor;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private JerseyService jerseyService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	public synchronized Order createOrder(
			ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user
			) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem: cartItemList) {
			Jersey jersey = cartItem.getJersey();
			cartItem.setOrder(order);
			jersey.setInStockNumber(jersey.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}
}
