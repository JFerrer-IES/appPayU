package com.vintec.appPayU;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>{


}
