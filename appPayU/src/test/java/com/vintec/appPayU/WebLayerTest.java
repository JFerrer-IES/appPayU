package com.vintec.appPayU;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void okViewsMessage() throws Exception {
    	//Pruebas solo a las vistas, se envia una peticion get y se espera un status 200
		this.mockMvc.perform(get("/exito")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(get("/error")).andDo(print()).andExpect(status().isOk());
		
		this.mockMvc.perform(get("/productos_json")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(get("/productos/1")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(get("/usuarios_json")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(get("/usuarios/1")).andDo(print()).andExpect(status().isOk());
    }
}
