package com.vintec.appPayU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vintec.appPayU.dtos.CreditCardToken;
import com.vintec.appPayU.services.TokenService;

@Controller
public class TokenController {
	
	@Autowired
	TokenService tokenService;

	@PostMapping("/token")
	public String generaToken(@ModelAttribute CreditCardToken creditCardToken, Model model) {
		model.addAttribute("token", tokenService.tokenRequest(creditCardToken, model));
		return tokenService.siguienteVista(tokenService.tokenRequest(creditCardToken, model));
	}
}
