package com.vintec.appPayU;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(UsuarioRepository urepository, ProductosRepository prepository, OrdenRepository orepository) {
		return (args) -> {
			Usuario us= new Usuario("Eduardo", "López","23/02/1996","eduardo_zamu@hotmail.com","d","Romulo","CDMX","MX","07800");
			urepository.save( us);
			Productos pr=new Productos("ProductoA","ProductoA Descripción", "55");
			prepository.save(pr);
			orepository.save(new Orden(us,"Referencia", "Firma",pr,"55"));
			

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			log.info("Muestra todos los clinetes");
			for (Usuario usuario : urepository.findAll()) {
				log.info(usuario.toString());
			}
			for (Productos productos : prepository.findAll()) {
				log.info(productos.toString());
			}
			for (Orden orden: orepository.findAll()) {
				log.info(orden.toString());
			}
			
		};
	}
}