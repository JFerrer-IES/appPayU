package com.vintec.appPayU.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.repositories.UsuarioRepository;

@Controller
public class InicioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		List<Usuario> usuario = new ArrayList<>();
	    model.addAttribute("usuario", usuario);
	    List<Usuario> usuarios = usuarioRepository.findAll();
	    model.addAttribute("usuarios", usuarios);
		return "index";
	}

}
