package com.soccerjerseystore.repository;

import org.springframework.data.repository.CrudRepository;

import com.soccerjerseystore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	
}
