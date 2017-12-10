package com.soccerjerseystore.repository;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{

}
