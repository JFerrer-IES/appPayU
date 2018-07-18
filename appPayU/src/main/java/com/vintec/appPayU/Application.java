package com.vintec.appPayU;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.models.Producto;
import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.repositories.OrdenRepository;
import com.vintec.appPayU.repositories.ProductoRepository;
import com.vintec.appPayU.repositories.UsuarioRepository;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(OrdenRepository ordenRepository, ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {

		return (args) -> {
			// guardamos unos cuantos usuarios
			usuarioRepository.save(new Usuario("Eduardo", "López","1996-02-13","eduardo_zamu@hotmail.com", "51135288","d","Romulo","CDMX","MX","07800"));
			usuarioRepository.save(new Usuario("Luis", "López","1992-03-15","luis@hotmail.com", "52335180","r","Zerman","CDMX","MX","07850"));
			usuarioRepository.save(new Usuario("Andrea", "Peredo","1996-06-20","andrea@hotmail.com", "55135690", "a","Fundidora","CDMX","MX","07820"));
			
			// guardamos unos cuantos productos
			productoRepository.save(new Producto("Moto E5 ","Smartphone Motorola Moto E5 16 GB dorado AT&T",3699));
			productoRepository.save(new Producto("IPad Mini 4","IPad Apple Mini 4 128 Gb gris oscuro",9899));
			productoRepository.save(new Producto("Pantalla Samsung 4K 50 pulgadas","Pantalla Samsung Ultra HD 50 Pulgadas UN50MU6103FXZX",10999));
			
			// guardamos unas cuantas ordenes
			ordenRepository.save(new Orden("Referencia 1", "Firma 1", "150.80"));
			ordenRepository.save(new Orden("Referencia 2", "Firma 2", "10.30"));
			ordenRepository.save(new Orden("Referencia 3", "Firma 3", "320.10"));
			
			log.info(" ");
			
			//Vamos a asignarle una orden con dos productos a un usuario
			log.info("al usuario 1 le agregamos la orden 1 :");
			log.info("--------------------------------------------");
			try {
				usuarioRepository.findById(1L).ifPresent(usuario -> {
					ordenRepository.findById(1L).ifPresent(orden -> {
						orden.setUsuario(usuario);
						usuario.getOrdenes().add(orden);
						usuarioRepository.save(usuario);
						productoRepository.findById(1L).ifPresent(producto -> {
							orden.getProductos().add(producto);
						});
						productoRepository.findById(2L).ifPresent(producto -> {
							orden.getProductos().add(producto);
						});
						ordenRepository.save(orden);
					});
				});
				log.info("Tarea completada con exito!!");
				log.info(" ");
			} catch(Exception ex) {
				log.info("Registros no encontrados, error en la operacion... ");
				log.info(ex.toString());
				log.info("");
			}
			
			//Vamos a asignarle otra orden al usuario 1
			log.info("al usuario 1 le agregamos la orden 2 :");
			log.info("--------------------------------------------");
			try {
				usuarioRepository.findById(1L).ifPresent(usuario -> {
					ordenRepository.findById(2L).ifPresent(orden -> {
						orden.setUsuario(usuario);
						usuario.getOrdenes().add(orden);
						usuarioRepository.save(usuario);
					});
				});
				log.info("Tarea completada con exito!!");
				log.info(" ");
			} catch(Exception ex) {
				log.info("Registros no encontrados, error en la operacion... ");
				log.info(ex.toString());
				log.info("");
			}
			
			// realizamos una busqueda de todos los usuarios
			log.info("");
			log.info("Usuarios");
			log.info("-------------------------------");
			for (Usuario usuario : usuarioRepository.findAll()) {
				log.info(usuario.toString());
				if(usuario.getOrdenes() != null) {
					usuario.getOrdenes().stream().forEach(orden -> {
							log.info(orden.toString());
							orden.getProductos().stream().forEach(producto -> log.info(producto.toString()));
						});
					log.info(" ");
				}
			}
			// realizamos una busqueda de todos los productos
			log.info("");
			log.info("Productos");
			log.info("-------------------------------");
			for (Producto producto : productoRepository.findAll()) {
				log.info(producto.toString());
			}
			// realizamos una busqueda de todas las ordenes
			log.info("");
			log.info("Ordenes");
			log.info("-------------------------------");
			for (Orden orden : ordenRepository.findAll()) {
				log.info(orden.toString());
				if(orden.getUsuario() != null) {
					log.info(orden.getUsuario().toString());
					orden.getProductos().stream().forEach(producto -> log.info(producto.toString()));
					log.info(" ");
				}
			}
			log.info("");
					
		}; //Aqui acaba el return (args)
	} // Termina bean 

}  
