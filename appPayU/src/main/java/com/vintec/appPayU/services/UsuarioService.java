package com.vintec.appPayU.services;

import com.vintec.appPayU.models.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> obtenerUsuarios();
	
	public Usuario buscarUsuario(Long usuarioId);
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario modificarUsuario(Long usuarioId, Usuario usuarioRequest);
	
	public void borrarUsuario(Long usuarioId);
}
