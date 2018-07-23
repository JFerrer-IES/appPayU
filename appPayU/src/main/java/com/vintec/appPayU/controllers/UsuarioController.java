package com.vintec.appPayU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.repositories.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios_json")
	public Iterable<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuarios/{usuarioId}")
	public Usuario searchUsuario(@PathVariable (value = "usuarioId") Long usuarioId){
		return usuarioRepository.findById(usuarioId).get();
	}
	
	@PostMapping("/usuarios")
	public Usuario createUsuario(@ModelAttribute Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuarios/{usuarioId}")
	public Usuario updateUsuario(@PathVariable Long usuarioId, @ModelAttribute Usuario usuarioRequest) {
		try {
	        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
	            usuario.setName(usuarioRequest.getName());
	            usuario.setLastName(usuarioRequest.getLastName());
	            usuario.setBirthdate(usuarioRequest.getBirthdate());
	            usuario.setEmailAddress(usuarioRequest.getEmailAddress());
	            usuario.setPhone(usuarioRequest.getPhone());
	            usuario.setDniNumber(usuarioRequest.getDniNumber());
	            usuario.setStreet1(usuarioRequest.getStreet1());
	            usuario.setCity(usuarioRequest.getCity());
	            usuario.setContry(usuarioRequest.getContry());
	            usuario.setPostalCode(usuarioRequest.getPostalCode());
	            usuarioRepository.save(usuario);
	        });
		}catch (Exception ex) {
			System.err.println("Usuario " +usuarioId+ " no encontrado");
		}
		return usuarioRepository.findById(usuarioId).get();
    }
	
	@DeleteMapping(path = "/usuarios/{usuarioId}", produces = "text/plain")
	@ResponseBody
    public String deleteUsuario(@PathVariable Long usuarioId) {
        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
            usuarioRepository.delete(usuario);
        });
        return "Borrado completado con exito!";
    }
	
}
