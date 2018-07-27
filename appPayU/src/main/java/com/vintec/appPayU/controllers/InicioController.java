package com.vintec.appPayU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vintec.appPayU.dtos.CreditCardRequest;
import com.vintec.appPayU.dtos.TokenResponse;
import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.services.InicioService;
import com.vintec.appPayU.services.ProductoService;
import com.vintec.appPayU.services.UsuarioService;

@Controller
public class InicioController {
	
	@Autowired
	InicioService inicioService;
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/")
	public String loadPage(Model model) {
		inicioService.cargaPagina(model);
		return "index";
	}
	
	@PostMapping("/ordenes")
    public String createOrderAndProduct(@ModelAttribute ("usuarioId") Long usuarioId, @ModelAttribute ("productoId") Long productoId, @ModelAttribute Orden orden, @ModelAttribute CreditCardRequest cc ) {
		inicioService.cargaUsuarioAOrden(usuarioId, orden);
		inicioService.cargaProductoAOrden(productoId, orden);
		inicioService.guardaOrden(orden);
		return inicioService.pagoRequest(usuarioId, orden, cc);
    }
	
	@PostMapping(value="/")
	public String createProducto(@ModelAttribute Producto producto, Model model){
		productoService.guardarProducto(producto);
		inicioService.cargaPagina(model);
		return "index";
	}
	
	@PostMapping(value="/usuarios")
	public String createUsuario(@ModelAttribute Usuario usuario, Model model){
		usuarioService.guardarUsuario(usuario);
		inicioService.cargaPagina(model);
		return "index";
	}
	
	@GetMapping(value="/exito")
	public String exito() {
		return "exito";
	}
	
	@GetMapping(value="/error")
	public String error() {
		return "error";
	}
	
	@PostMapping(value="/exitoToken")
	public String token(@ModelAttribute TokenResponse tokenResponse) {
		return "token";
	}

}
