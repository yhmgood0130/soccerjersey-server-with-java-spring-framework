package com.soccerjerseystore.repository;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long>{

}
