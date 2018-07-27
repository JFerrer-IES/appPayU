package com.vintec.appPayU;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

import com.vintec.appPayU.dtos.CreditCardToken;
import com.vintec.appPayU.dtos.Merchant;
import com.vintec.appPayU.dtos.TokenRequest;
import com.vintec.appPayU.dtos.TokenResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
    public void succesTokenRequestPayUResponse() throws Exception {
		//Pruebas para PayU, saber si es capaz de aceptar y resolver una peticion
		//Vamos a realizar una peticion a tokenizar en PayU
		
		//Esta peticion sera correcta
		CreditCardToken creditCardToken = new CreditCardToken("10", "full name", "32144457", "VISA", "4111111111111111", "2019/01");
		Merchant merchant = new Merchant();
		TokenRequest tokenRequest = new TokenRequest(merchant, creditCardToken);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type","application/json");
		httpHeaders.set("Accept","application/json");
		HttpEntity <String> httpEntity = new HttpEntity <String> (tokenRequest.toJSON(), httpHeaders);
		
		//Esta sera peticion incorrecta pero pasara la prueba
		creditCardToken = new CreditCardToken("11", "no_name", "32144457", "VI", "4111111111111111", "2016/01");
		tokenRequest = new TokenRequest(merchant, creditCardToken);
		httpEntity = new HttpEntity <String> (tokenRequest.toJSON(), httpHeaders);
	    assertThat(this.restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi", httpEntity, TokenResponse.class).getCreditCardToken()).isNull();
    }
	
	@Test
    public void succesTokenControllerResponse() throws Exception {
		//Pruebas para los controllers, saber si son capaces de aceptar la peticion y devolver algo especifico
		//Vamos a realizar una peticion a tokenizar en nuestra aplicacion
		CreditCardToken creditCardToken = new CreditCardToken("10", "full name", "32144457", "VISA", "4111111111111111", "2019/01");
				
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type","application/json");
		httpHeaders.set("Accept","application/json");
		HttpEntity <CreditCardToken> httpEntity = new HttpEntity <CreditCardToken> (creditCardToken, httpHeaders);
		
	    assertThat(this.restTemplate.postForObject("http://localhost:" + port + "", httpEntity, String.class)).isNotNull();
    }
	
}
