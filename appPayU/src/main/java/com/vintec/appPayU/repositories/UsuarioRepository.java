package com.vintec.appPayU.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vintec.appPayU.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Page<Usuario> findAll(Pageable pageable);
}
