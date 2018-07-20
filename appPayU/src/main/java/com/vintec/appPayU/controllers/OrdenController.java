package com.vintec.appPayU.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vintec.appPayU.exceptions.ResourceNotFoundException;
import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.repositories.OrdenRepository;
import com.vintec.appPayU.repositories.ProductoRepository;
import com.vintec.appPayU.repositories.UsuarioRepository;


@RestController
public class OrdenController {

	@Autowired
	OrdenRepository ordenRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	
	@GetMapping("/ordenes_json")
	public Iterable<Orden> getAllOrdenes() {
      return ordenRepository.findAll();
	}
	
	@GetMapping("/ordenes/{ordenId}")
	public Orden searchOrden(@PathVariable (value = "ordenId") Long ordenId){
		return ordenRepository.findById(ordenId).get();
	}
	
	@GetMapping("/usuarios/{usuarioId}/ordenes_json")
    public Iterable<Orden> getAllOrdenesByUsuarioId(@PathVariable (value = "usuarioId") Long usuarioId) {
        return ordenRepository.findByUsuarioId(usuarioId);
    }
	
	@PostMapping("/usuarios/{usuarioId}/ordenes")
    public Orden createOrden(@PathVariable (value = "usuarioId") Long usuarioId, @Valid @RequestBody Orden orden) {
        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
            orden.setUsuario(usuario);
        });
        return ordenRepository.save(orden);
    }
	
	@PostMapping("/usuarios/{usuarioId}/ordenes/{productoId}")
    public Orden createOrdenConProducto(@PathVariable (value = "usuarioId") Long usuarioId, @PathVariable (value = "productoId") Long productoId, @Valid @RequestBody Orden orden) {
        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
            orden.setUsuario(usuario);
        });
        productoRepository.findById(productoId).ifPresent(producto -> {
        	orden.getProductos().add(producto);
        });
        return ordenRepository.save(orden);
    }
	
	@PutMapping("/usuarios/{usuarioId}/ordenes/{ordenId}")
    public Orden updateOrden(@PathVariable (value = "usuarioId") Long usuarioId,
                                 @PathVariable (value = "ordenId") Long ordenId,
                                 @Valid @RequestBody Orden ordenRequest) {
        if(!usuarioRepository.existsById(usuarioId)) {
            throw new ResourceNotFoundException("UsuarioId " + usuarioId + " no encontrado");
        }
        else {
	        ordenRepository.findById(ordenId).ifPresent(orden -> {
	            orden.setReferencia(ordenRequest.getReferencia());
	            orden.setFirma(ordenRequest.getFirma());
	            orden.setTotal(ordenRequest.getTotal());
	            ordenRepository.save(orden);
	        });
        }
        return ordenRepository.findById(ordenId).get();
    }
	
	@DeleteMapping("/usuarios/{usuarioId}/ordenes/{ordenId}")
    public String deleteOrden(@PathVariable (value = "usuarioId") Long usuarioId,
                              @PathVariable (value = "ordenId") Long ordenId) {
        if(!usuarioRepository.existsById(usuarioId)) {
            throw new ResourceNotFoundException("UsuarioId " + usuarioId + " no encontrado");
        }

        ordenRepository.findById(ordenId).ifPresent(orden -> {
             ordenRepository.delete(orden);
        });
        return "Borrado completado con exito!";
    }

}
