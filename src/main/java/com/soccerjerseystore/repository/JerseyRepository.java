package com.soccerjerseystore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.Jersey;

public interface JerseyRepository extends CrudRepository<Jersey, Long>{
	List<Jersey> findByTitleContaining(String keyword);
}
