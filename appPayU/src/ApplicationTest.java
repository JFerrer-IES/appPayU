package appPayU;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.vintec.appPayU.Application;
import com.vintec.appPayU.models.CreditCardRequest;
import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.services.impl.ServicesImplOrden;
import com.vintec.appPayU.services.impl.ServicesImplProducto;
import com.vintec.appPayU.services.impl.ServicesImplementUsuario;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@Rollback
public class ApplicationTest {
	@Autowired
	private ServicesImplementUsuario usuarioService;

	@Autowired
	private ServicesImplOrden ordenService;

	@Autowired
	private ServicesImplProducto productoService;

	@Test
	@Rollback
	public void probarGuardadoDeproducto() {
		Producto producto = new Producto("Audifono", "descripcion", 50);
		if (producto != null) {
			productoService.createProductos(producto);
			assertNotNull("id no es nulo", producto.getId());
			assertNotNull("nombre no es nulo", producto.getName_product());
			assertNotNull("desripcion no es nulo", producto.getDescription_product());
			assertNotNull("precio no es nulo", producto.getPrice_product());
			assertNotNull("New Order is not null", producto);
		}
	}

	@Test
	@Rollback
	public void probarGuardadoUsuario() {
		Usuario usuario = new Usuario("Eduardo", "Lopez", "1996-02-13", "eduardo@hotmail.com", "51135288", "d",
				"Romulo", "CDMX", "MX", "MX", "07800");
		if (usuario != null) {
			usuarioService.createUsuario(usuario);
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
	public void probarGuardadoOrden() {
		Orden ord = new Orden("Referencia 1", "Firma 1", "150.80");
		new Usuario("Eduardo", "Lopez", "1996-02-13", "eduardo@hotmail.com", "51135288", "d", "Romulo", "CDMX", "MX",
				"MX", "07800");
		new Producto("Audifono", "descripcion", 50);
		CreditCardRequest cc = new CreditCardRequest("4083345039770442", "916", "2018/09", "REJECTED", "VISA");
		if (ord != null) {
			ordenService.createOrdeni(1L, ord);
			ordenService.createOrdenConProducto(1L, 1L, ord, cc);
			assertNotNull(ord.getFirma());
			assertNotNull(ord.getId());
			assertNotNull(ord.getProductos());
			assertNotNull(ord.getReferencia());
			assertNotNull(ord.getTotal());
			assertNotNull(ord.getUsuario());
			assertNotNull(ord);
		}

	}
}
	