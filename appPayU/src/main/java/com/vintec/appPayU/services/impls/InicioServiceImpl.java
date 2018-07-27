package com.vintec.appPayU.services.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.vintec.appPayU.dtos.CreditCardRequest;
import com.vintec.appPayU.dtos.MerchantRequest;
import com.vintec.appPayU.dtos.OrderRequest;
import com.vintec.appPayU.dtos.PagoRequest;
import com.vintec.appPayU.dtos.PagoResponse;
import com.vintec.appPayU.dtos.TransactionRequest;
import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.repositories.OrdenRepository;
import com.vintec.appPayU.repositories.ProductoRepository;
import com.vintec.appPayU.repositories.UsuarioRepository;
import com.vintec.appPayU.services.InicioService;

@Service("inicioService")
public class InicioServiceImpl implements InicioService{

	Logger log = LoggerFactory.getLogger(InicioServiceImpl.class);
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	OrdenRepository ordenRepository;
	
	@Override
	public Model cargaPagina(Model model) {
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
	    return model;
	}

	@Override
	public Orden cargaUsuarioAOrden(Long usuarioId, Orden orden) {
		usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
        	orden.setUsuario(usuario);
        });
		return orden;
	}
	
	@Override
	public Orden cargaProductoAOrden(Long productoId, Orden orden) {
        productoRepository.findById(productoId).ifPresent(producto -> {
        	orden.getProductos().add(producto);
        });
        double subtotal = 0;
        Set<Producto> productos = orden.getProductos();
    	for (Producto producto : productos) {
    		  subtotal += producto.getPrice_product();
    		}
    	orden.setTotal(String.valueOf(subtotal));
		return orden;
	}
	
	@Override
	public void guardaOrden(Orden orden) {
		ordenRepository.save(orden);
	}
	
	@Override
	public String pagoRequest(Long usuarioId, Orden orden, CreditCardRequest cc) {
		MerchantRequest merchant = new MerchantRequest();
		Usuario us = usuarioRepository.findById(usuarioId).get();
		OrderRequest order = new OrderRequest(orden, us);
		TransactionRequest t = new TransactionRequest(order, us, cc);
		PagoRequest pago = new PagoRequest(merchant, t);
		
		//CreditCardRequest cc= new CreditCardRequest("4083345039770442","916","2018/09", "REJECTED","VISA");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(pago.toJsonPago(), httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		PagoResponse pagoResponse = restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi", httpEntity, PagoResponse.class);
		
		log.info(" ");
		log.info("Aqui esta la respuesta del servidor");
		log.info("---------------------------------------");
		log.info(pagoResponse.toString());
		log.info("---------------------------------------");
		
		if(siguienteVista(pagoResponse))
			return "exito";
		else
			return "error";
	}
	
	@Override
	public boolean siguienteVista(PagoResponse pagoResponse) {
		if(pagoResponse.getCode().toLowerCase().equals("success"))
			return true;
		else
			return false;
	}
	
}

