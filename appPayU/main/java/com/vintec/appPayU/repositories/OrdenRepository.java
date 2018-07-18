package com.vintec.appPayU.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vintec.appPayU.models.Orden;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, Long>{

	Page<Orden> findByUsuarioId (Long usuarioId, Pageable pageable);
}

