package com.vintec.appPayU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios_json")
	public Iterable<Usuario> getAllUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@GetMapping("/usuarios/{usuarioId}")
	public Usuario searchUsuario(@PathVariable (value = "usuarioId") Long usuarioId){
		return usuarioService.buscarUsuario(usuarioId);
	}
	
//	@PostMapping("/usuarios")
//	public Usuario createUsuario(@ModelAttribute Usuario usuario){
//		return usuarioService.guardarUsuario(usuario);
//	}
	
	@PutMapping("/usuarios/{usuarioId}")
	public Usuario updateUsuario(@PathVariable Long usuarioId, @ModelAttribute Usuario usuarioRequest) {
		return usuarioService.modificarUsuario(usuarioId, usuarioRequest);
    }
	
	@DeleteMapping(path ="/usuarios/{usuarioId}", produces = "text/plain")
	@ResponseBody
    public String deleteUsuario(@PathVariable Long usuarioId) {
		usuarioService.borrarUsuario(usuarioId);
        return "Borrado completado con exito!";
    }
	
}
