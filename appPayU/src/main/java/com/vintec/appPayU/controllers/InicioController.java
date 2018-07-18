package com.vintec.appPayU.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
}
