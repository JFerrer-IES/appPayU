package com.vintec.appPayU.services;

import com.vintec.appPayU.models.Orden;

public interface OrdenService {

	public Iterable<Orden> obtenerOrdenes();
	
	public Orden buscarOrden(Long ordenId);
	
	public Iterable<Orden> obtenerOrdenesPorUsuarioId(Long usuarioId);
	
	public Orden guardarOrden(Long usuarioId, Orden orden);
	
	public Orden actualizarOrden(Long ordenId, Orden ordenRequest);
	
	public void borrarOrden(Long ordenId);
}
