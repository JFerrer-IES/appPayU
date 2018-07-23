package com.vintec.appPayU.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.vintec.appPayU.models.CreditCardRequest;
import com.vintec.appPayU.models.MerchantRequest;
import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.models.OrderRequest;
import com.vintec.appPayU.models.PagoRequest;
import com.vintec.appPayU.models.PagoResponse;
import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.models.TokenResponse;
import com.vintec.appPayU.models.TransactionRequest;
import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.repositories.OrdenRepository;
import com.vintec.appPayU.repositories.ProductoRepository;
import com.vintec.appPayU.repositories.UsuarioRepository;

@Controller
public class InicioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	OrdenRepository ordenRepository;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		List<Usuario> usuario = new ArrayList<>();
	    model.addAttribute("usuario", usuario);
	    List<Usuario> usuarios = usuarioRepository.findAll();
	    model.addAttribute("usuarios", usuarios);
	    List<Producto> producto = new ArrayList<>();
	    model.addAttribute("producto", producto);
	    List<Producto> productos = productoRepository.findAll();
	    model.addAttribute("productos", productos);
	    model.containsAttribute("usuarioId");
	    model.containsAttribute("productoId");
		return "index";
	}
	
	@PostMapping("/ordenes")
    public String createOrdenConProducto(@ModelAttribute ("usuarioId") Long usuarioId, @ModelAttribute ("productoId") Long productoId, @ModelAttribute Orden orden, @ModelAttribute CreditCardRequest cc ) {
		
		Logger log = LoggerFactory.getLogger(InicioController.class);
		
		usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
        	orden.setUsuario(usuario);
        });
        productoRepository.findById(productoId).ifPresent(producto -> {
        	orden.getProductos().add(producto);
        });
        double subtotal = 0;
        Set<Producto> productos = orden.getProductos();
		for (Producto producto : productos) {
			  subtotal += producto.getPrice_product();
			}
		orden.setTotal(String.valueOf(subtotal));
		ordenRepository.save(orden);
		
		//Peticion de pago
		//CreditCardRequest cc= new CreditCardRequest("4083345039770442","916","2018/09", "REJECTED","VISA");
		MerchantRequest merchant = new MerchantRequest();
		Usuario us = usuarioRepository.findById(usuarioId).get();
		OrderRequest order = new OrderRequest(orden, us);
		TransactionRequest t = new TransactionRequest(order, us, cc);
		PagoRequest pago = new PagoRequest(merchant, t);

		// Aqui va la peticion al servidor PayU
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(pago.toJsonPago(), httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		String respuesta = restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi", httpEntity, String.class);
		PagoResponse pagoResponse = restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi", httpEntity, PagoResponse.class);
		//Termina la peticion y da respuesta
		
		log.info(" ");
		log.info("Aqui esta la respuesta del servidor");
		log.info("---------------------------------------");
		log.info(respuesta);
		log.info(pago.toJsonPago());
		log.info(pagoResponse.toString());
		
		if(pagoResponse.getCode().toLowerCase().equals("success")) {
			return "exito";
		} else {
			return "error";
		}
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
