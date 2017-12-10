package com.soccerjerseystore.service;

import com.soccerjerseystore.domain.BillingAddress;
import com.soccerjerseystore.domain.Order;
import com.soccerjerseystore.domain.Payment;
import com.soccerjerseystore.domain.ShippingAddress;
import com.soccerjerseystore.domain.ShoppingCart;
import com.soccerjerseystore.domain.User;

public interface OrderService {
	Order createOrder(
			ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user
			);
}
