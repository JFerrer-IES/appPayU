package com.vintec.appPayU;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void okIndexMessage() throws Exception {
		//Prueba para Application.java, revisa si se levantaron los servicios del servidor HTTP
		//Se en via una peticion get esperando un status 200
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}
}
