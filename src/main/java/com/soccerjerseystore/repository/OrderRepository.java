package com.soccerjerseystore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.Order;
import com.soccerjerseystore.domain.User;

public interface OrderRepository extends CrudRepository<Order, Long>{
	List<Order> findByUser(User user);
}
