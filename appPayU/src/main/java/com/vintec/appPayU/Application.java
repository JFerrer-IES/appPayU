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
	public CommandLineRunner demo(ProductoRepository productRepository) {

		return (args) -> {
			
			// guardamos unos cuantos productos
			productRepository.save(new Producto("Moto E5 ","Smartphone Motorola Moto E5 16 GB dorado AT&T","3699"));
			productRepository.save(new Producto("IPad Mini 4","IPad Apple Mini 4 128 Gb gris oscuro","9899"));
			productRepository.save(new Producto("Pantalla Samsung 4K 50 pulgadas","Pantalla Samsung Ultra HD 50 Pulgadas UN50MU6103FXZX","10999"));
			
			// realizamos una busqueda de todos los productos
			log.info("");
			log.info("Productos encontrados con findAll():");
			log.info("-------------------------------");
			for (Producto producto : productRepository.findAll()) {
				log.info(producto.toString());
			}
			log.info("");
					
		}; //Aqui acaba el return (args)
	} // Termina bean 

}  
