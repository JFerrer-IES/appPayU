package com.vintec.appPayU;

import org.springframework.data.repository.CrudRepository;

import com.vintec.appPayU.Orden;

public interface OrderRepository extends CrudRepository<Orden, Long> {
	
}
