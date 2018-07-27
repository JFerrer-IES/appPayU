package com.vintec.appPayU.services.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.vintec.appPayU.dtos.CreditCardToken;
import com.vintec.appPayU.dtos.Merchant;
import com.vintec.appPayU.dtos.TokenRequest;
import com.vintec.appPayU.dtos.TokenResponse;
import com.vintec.appPayU.services.TokenService;

@Service("tokenService")
public class TokenServiceImpl implements TokenService{
	
	Logger log = LoggerFactory.getLogger(InicioServiceImpl.class);

	@Override
	public TokenResponse tokenRequest(CreditCardToken creditCardToken, Model model) {
		
		// new CreditCardToken("10", "full name", "32144457", "VISA", "4111111111111111", "2019/01");
		Merchant merchant = new Merchant();
		TokenRequest tokenRequest = new TokenRequest(merchant, creditCardToken);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(tokenRequest.toJSON(), httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		TokenResponse tokenResponse = restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi", httpEntity, TokenResponse.class);
		
		log.info(" ");
		log.info("Aqui esta la respuesta del servidor");
		log.info("---------------------------------------");
		log.info(tokenResponse.toString());
		log.info("---------------------------------------");
		
		return tokenResponse;
	}
	
	@Override
	public String siguienteVista(TokenResponse tokenResponse) {
		if (tokenResponse.getCode().toLowerCase().equals("success"))
			return "token";
		else
			return "error";
	}
}
