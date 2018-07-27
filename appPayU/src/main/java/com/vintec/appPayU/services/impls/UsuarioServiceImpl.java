package com.vintec.appPayU.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vintec.appPayU.models.Usuario;
import com.vintec.appPayU.repositories.UsuarioRepository;
import com.vintec.appPayU.services.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Usuario> obtenerUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@Override
	public Usuario buscarUsuario(Long usuarioId){
		return usuarioRepository.findById(usuarioId).get();
	}
	
	@Override
	public Usuario guardarUsuario(Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario modificarUsuario(Long usuarioId, Usuario usuarioRequest) {
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
		return usuarioRepository.findById(usuarioId).get();
    }
	
	@Override
    public void borrarUsuario(Long usuarioId) {
        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
            usuarioRepository.delete(usuario);
        });
        return;
    }
}
