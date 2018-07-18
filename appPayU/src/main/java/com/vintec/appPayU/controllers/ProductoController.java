package com.vintec.appPayU.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.repositories.ProductoRepository;

@RestController
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/productos_json")
    public Iterable<Producto> getAllProductos() {
		return productoRepository.findAll();
	}
	
	@GetMapping("/productos/{productoId}")
	public Producto searchProducto(@PathVariable (value = "productoId") Long productoId){
		return productoRepository.findById(productoId).get();
	}
	
	@PostMapping("/productos")
	public Producto createUsuario(@Valid @RequestBody Producto producto){
		return productoRepository.save(producto);
	}
	
	@PutMapping("/productos/{productoId}")
	public Producto updateProducto(@PathVariable Long productoId, @Valid @RequestBody Producto productoRequest) {
		try {
	        productoRepository.findById(productoId).ifPresent(producto -> {
	        	producto.setName_product(productoRequest.getName_product());
	        	producto.setDescription_product(productoRequest.getDescription_product());
	        	producto.setPrice_product(productoRequest.getPrice_product());
	            productoRepository.save(producto);
	        });
		}catch (Exception ex) {
			System.err.println("Usuario " +productoId+ " no encontrado");
		}
		return productoRepository.findById(productoId).get();
    }
	
	@DeleteMapping(path = "/productos/{productoId}", produces = "text/plain")
	@ResponseBody
    public String deleteUsuario(@PathVariable Long productoId) {
        productoRepository.findById(productoId).ifPresent(producto -> {
            productoRepository.delete(producto);
        });
        return "Borrado completado con exito!";
    }
}
