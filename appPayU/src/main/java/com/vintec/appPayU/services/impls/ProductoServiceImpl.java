package com.vintec.appPayU.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.repositories.ProductoRepository;
import com.vintec.appPayU.services.ProductoService;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
    public Iterable<Producto> obtenerProductos() {
		return productoRepository.findAll();
	}
    
	@Override
	public Producto buscarProducto(Long productoId){
		return productoRepository.findById(productoId).get();
	}
	
	@Override
	public Producto guardarProducto(Producto producto){
		return productoRepository.save(producto);
	}
	
	@Override
	public Producto actualizarProducto(Long productoId, Producto productoRequest) {
		productoRepository.findById(productoId).ifPresent(producto -> {
			producto.setName_product(productoRequest.getName_product());
			producto.setDescription_product(productoRequest.getDescription_product());
			producto.setPrice_product(productoRequest.getPrice_product());
			productoRepository.save(producto);
		});
		return productoRepository.findById(productoId).get();
	}
	
	@Override
    public void borrarProducto(Long productoId) {
        productoRepository.findById(productoId).ifPresent(producto -> {
            productoRepository.delete(producto);
        });
        return;
    }
}
