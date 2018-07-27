package appPayU;

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
import org.springframework.web.client.RestTemplate;

import com.vintec.appPayU.Application;
import com.vintec.appPayU.models.CreditCardRequest;
import com.vintec.appPayU.models.MerchantRequest;
import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.models.OrderRequest;
import com.vintec.appPayU.models.PagoRequest;
import com.vintec.appPayU.models.TransactionRequest;
import com.vintec.appPayU.models.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { Application.class })
public class HttpRequestTest {

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void PaginaDisponibleLocal() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
				.contains("Bienvenidos");
	}

	@Test
	public void PaginaproductosDisponibleLocal() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/productos_json", String.class))
				.contains("\"id\"");
	}

	@Test
	public void PaginaordenesDisponibleLocal() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/ordenes_json", String.class))
				.contains("\"id\"");
	}

	@Test
	public void PaginaUsuariosDisponibleLocal() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/usuarios_json", String.class))
				.contains("\"id\"");
	}

	@Test
	public void PaginaTokenDisponibleLocal() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + " \token", String.class))
				.contains("Error");
	}

	@Test
	public void PaginaDisponiblePayU() throws Exception {
		assertThat(this.restTemplate.getForObject("https://sandbox.api.payulatam.com/payments-api/", String.class))
				.contains("Payments API Running");
	}

	@Test
	public void EnvioJson() throws Exception {
		MerchantRequest merchant = new MerchantRequest();
		Usuario us = new Usuario("Eduardo", "Lopez", "1996-02-23", "eduardo@hotmail.com", "51135288", "5415668464654",
				"Romulo", "CDMX", "MX", "MX", "07800");
		Orden ordeeen = new Orden("", "", "180.5", us);
		OrderRequest order = new OrderRequest(ordeeen, us);
		CreditCardRequest cc = new CreditCardRequest("4083345039770442", "916", "2018/09", "REJECTED", "VISA");
		TransactionRequest t = new TransactionRequest(order, us, cc);
		PagoRequest pago = new PagoRequest(merchant, t);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(pago.toJsonPago(), httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		assertThat(restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi",
				httpEntity, String.class)).contains("SUCCESS");
	}

	@Test
	public void EnvioToken() throws Exception {
		CreditCardRequest cc = new CreditCardRequest("4083345039770442", "916", "2018/09", "REJECTED", "VISA");
		// Aqui va la peticion al servidor PayU
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(cc.toJsonCreditCard(), httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		// Termina la peticion y da respuesta
		assertThat(restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi",
				httpEntity, String.class).contains("SUCCESS"));
	}

}
