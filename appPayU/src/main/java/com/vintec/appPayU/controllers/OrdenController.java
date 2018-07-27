package com.vintec.appPayU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.services.OrdenService;


@RestController
public class OrdenController {
	
	@Autowired
	OrdenService ordenService;
	
	@GetMapping("/ordenes_json")
	public Iterable<Orden> getAllOrdenes() {
      return ordenService.obtenerOrdenes();
	}
	
	@GetMapping("/ordenes/{ordenId}")
	public Orden searchOrden(@PathVariable (value = "ordenId") Long ordenId){
		return ordenService.buscarOrden(ordenId);
	}
	
	@GetMapping("/usuarios/{usuarioId}/ordenes_json")
    public Iterable<Orden> getAllOrdenesByUsuarioId(@PathVariable (value = "usuarioId") Long usuarioId) {
        return ordenService.obtenerOrdenesPorUsuarioId(usuarioId);
    }
	
	@PostMapping("/usuarios/{usuarioId}/ordenes")
    public Orden createOrden(@PathVariable (value = "usuarioId") Long usuarioId, @ModelAttribute Orden orden) {
        return ordenService.guardarOrden(usuarioId, orden);
    }
	
	@PutMapping("/ordenes/{ordenId}")
    public Orden updateOrden(@PathVariable (value = "ordenId") Long ordenId, @ModelAttribute Orden ordenRequest) {
        return ordenService.actualizarOrden(ordenId, ordenRequest);
    }
	
	@DeleteMapping("/ordenes/{ordenId}")
    public String deleteOrden(@PathVariable (value = "ordenId") Long ordenId) {
		ordenService.borrarOrden(ordenId);
        return "Borrado completado con exito!";
    }

}
