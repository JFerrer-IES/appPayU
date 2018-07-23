package com.vintec.appPayU.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.vintec.appPayU.models.CreditCardToken;
import com.vintec.appPayU.models.Merchant;
import com.vintec.appPayU.models.TokenRequest;
import com.vintec.appPayU.models.TokenResponse;

@Controller
public class TokenController {

	@PostMapping("/token")
	public String generaToken(@ModelAttribute CreditCardToken creditCardToken,Model model) {
		
		//new CreditCardToken("10", "full name", "32144457", "VISA", "4111111111111111", "2019/01");
		Merchant merchant = new Merchant();
		TokenRequest tokenRequest = new TokenRequest(merchant, creditCardToken);
		
		// Aqui va la peticion al servidor PayU
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(tokenRequest.toJSON(), httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		TokenResponse tokenResponse = restTemplate.postForObject("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi", httpEntity, TokenResponse.class);
		//Termina la peticion y da respuesta
		
	    model.addAttribute("token", tokenResponse);
		
		if(tokenResponse.getCode().toLowerCase().equals("success")) 
			return "token";
		else 
			return "error";
	}
}
