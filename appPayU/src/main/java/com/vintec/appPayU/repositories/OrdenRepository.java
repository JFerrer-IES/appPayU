package com.vintec.appPayU.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vintec.appPayU.models.Orden;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, Long>{

	Iterable<Orden> findByUsuarioId(Long usuarioId);
}

