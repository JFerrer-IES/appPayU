package com.vintec.appPayU.services;

import org.springframework.ui.Model;

import com.vintec.appPayU.dtos.CreditCardRequest;
import com.vintec.appPayU.dtos.PagoResponse;
import com.vintec.appPayU.models.Orden;

public interface InicioService {

	public Model cargaPagina (Model model);
	
	public Orden cargaUsuarioAOrden (Long usuarioId, Orden orden);
	
	public Orden cargaProductoAOrden (Long usuarioId, Orden orden);

	public void guardaOrden(Orden orden);
	
	public String pagoRequest(Long usuarioId, Orden orden, CreditCardRequest cc);
	
	public boolean siguienteVista(PagoResponse pagoResponse);
}
