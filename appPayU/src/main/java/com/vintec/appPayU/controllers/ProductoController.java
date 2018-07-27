package com.vintec.appPayU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.services.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/productos_json")
    public Iterable<Producto> getAllProductos() {
		return productoService.obtenerProductos();
	}
	
	@GetMapping("/productos/{productoId}")
	public Producto searchProducto(@PathVariable (value = "productoId") Long productoId){
		return productoService.buscarProducto(productoId);
	}
	
	@PostMapping("/productos")
	public Producto createProducto(@ModelAttribute Producto producto){
		return productoService.guardarProducto(producto);
	}
	
	@PutMapping("/productos/{productoId}")
	public Producto updateProducto(@PathVariable Long productoId, @ModelAttribute Producto productoRequest) {
		return productoService.actualizarProducto(productoId, productoRequest);
    }
	
	@DeleteMapping(path = "/productos/{productoId}", produces = "text/plain")
	@ResponseBody
    public String deleteUsuario(@PathVariable Long productoId) {
		productoService.borrarProducto(productoId);
        return "Borrado completado con exito!";
    }
}