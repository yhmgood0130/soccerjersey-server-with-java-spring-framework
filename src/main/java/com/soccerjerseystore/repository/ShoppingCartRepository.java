package com.soccerjerseystore.repository;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
