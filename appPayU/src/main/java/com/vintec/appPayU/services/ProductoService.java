package com.vintec.appPayU.services;

import com.vintec.appPayU.models.Producto;

public interface ProductoService {

	public Iterable<Producto> obtenerProductos();
	
	public Producto buscarProducto(Long productoId);
	
	public Producto guardarProducto(Producto producto);
	
	public Producto actualizarProducto(Long productoId, Producto productoRequest);
	
	public void borrarProducto(Long productoId);
}
