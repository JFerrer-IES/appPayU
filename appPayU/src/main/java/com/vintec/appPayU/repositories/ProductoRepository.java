package com.vintec.appPayU.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vintec.appPayU.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

	Page<Producto> findByOrdenId (Long ordenId, Pageable pageable);
}
