package com.vintec.appPayU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.repositories.OrdenRepository;
import com.vintec.appPayU.repositories.ProductoRepository;
import com.vintec.appPayU.repositories.UsuarioRepository;

@RestController
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	OrdenRepository ordenRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios/{usuarioId}/ordenes/{ordenId}/productos")
    public Page<Producto> getAllProductosByOrdenesId(@PathVariable (value = "usuarioId") Long usuarioId,
											    		@PathVariable (value = "ordenId") Long ordenId,
											    		Pageable pageable) {
		return productoRepository.findByOrdenId(ordenId, pageable);
	}
}
