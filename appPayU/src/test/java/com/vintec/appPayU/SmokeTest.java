package com.vintec.appPayU;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vintec.appPayU.controllers.InicioController;
import com.vintec.appPayU.controllers.OrdenController;
import com.vintec.appPayU.controllers.ProductoController;
import com.vintec.appPayU.controllers.TokenController;
import com.vintec.appPayU.controllers.UsuarioController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired
    private InicioController inicioController;
	
	@Autowired 
	private OrdenController ordenController;
	
	@Autowired 
	private ProductoController productoController;
	
	@Autowired 
	private TokenController tokenController;
	
	@Autowired 
	private UsuarioController usuarioController;

	@Autowired
	private Application application;
	
    @Test
    public void contexLoads() throws Exception {
    	//Vamos a ver si nuestras instancias en los controladores no expulsan NullPointerException
		assertThat(inicioController).isNotNull();
		assertThat(ordenController).isNotNull();
		assertThat(productoController).isNotNull();
		assertThat(tokenController).isNotNull();
		assertThat(usuarioController).isNotNull();
        
        //Ni en la aplicacion
        assertThat(application).isNotNull();
    }
}
