package com.vintec.appPayU;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.services.InicioService;
import com.vintec.appPayU.services.ProductoService;
import com.vintec.appPayU.services.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@Rollback
public class PersistenceTest {
	
	@Autowired
	private InicioService inicioService;
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ProductoService productoService;

	@Test
	@Rollback
	public void saveProduct() {
		Producto producto = new Producto("Audifono", "descripcion", 50);
		if (producto != null) {
			productoService.guardarProducto(producto);
			assertNotNull("id no es nulo", producto.getId());
			assertNotNull("nombre no es nulo", producto.getName_product());
			assertNotNull("desripcion no es nulo", producto.getDescription_product());
			assertNotNull("precio no es nulo", producto.getPrice_product());
			assertNotNull("New Order is not null", producto);
		}
	}

	@Test
	@Rollback
	public void saveUsuario() {
		Usuario usuario = new Usuario("Jorge", "Ferrer", "1997-02-04", "jferrer@hotmail.com", "52135289", "d",
				"Nepatl", "CDMX", "MX", "MX", "56334");
		if (usuario != null) {
			usuarioService.guardarUsuario(usuario);
			assertNotNull(usuario.getId());
			assertNotNull(usuario.getBirthdate());
			assertNotNull(usuario.getCity());
			assertNotNull(usuario.getContry());
			assertNotNull(usuario.getDniNumber());
			assertNotNull(usuario.getEmailAddress());
			assertNotNull(usuario.getLastName());
			assertNotNull(usuario.getName());
			assertNotNull(usuario.getPhone());
			assertNotNull(usuario.getPostalCode());
			assertNotNull(usuario.getStreet1());
			assertNotNull(usuario.getOrdenes());
		}
	}

	@Test
	@Rollback
	public void saveOrden() {
		Usuario usuario = new Usuario("Luis", "Lopez","1992-03-15","luis@hotmail.com", "52335180","r","Zerman","CDMX","MX", "MX", "07850");
		usuarioService.guardarUsuario(usuario);
		
		Orden orden = new Orden("payment_test_99900001", "69d419f89fb8ed7f80fd7b42bd2ff048", "9899.0", usuario);
		
		if (orden != null) {
			inicioService.guardaOrden(orden);
			assertNotNull(orden.getFirma());
			assertNotNull(orden.getId());
			assertNotNull(orden.getProductos());
			assertNotNull(orden.getReferencia());
			assertNotNull(orden.getTotal());
			assertNotNull(orden.getUsuario());
			assertNotNull(orden);
		}
	}
}

