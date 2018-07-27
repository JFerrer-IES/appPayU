package com.vintec.appPayU.services;

import org.springframework.ui.Model;

import com.vintec.appPayU.dtos.CreditCardToken;
import com.vintec.appPayU.dtos.TokenResponse;

public interface TokenService {

	public TokenResponse tokenRequest(CreditCardToken creditCardToken, Model model);
	
	public String siguienteVista(TokenResponse tokenResponse);
}
