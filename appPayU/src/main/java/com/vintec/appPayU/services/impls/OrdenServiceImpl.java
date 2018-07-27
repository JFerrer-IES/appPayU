package com.vintec.appPayU.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vintec.appPayU.models.Orden;
import com.vintec.appPayU.repositories.OrdenRepository;
import com.vintec.appPayU.repositories.ProductoRepository;
import com.vintec.appPayU.repositories.UsuarioRepository;
import com.vintec.appPayU.services.OrdenService;

@Service("ordenService")
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	OrdenRepository ordenRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public Iterable<Orden> obtenerOrdenes() {
	      return ordenRepository.findAll();
	}
	
	@Override
	public Orden buscarOrden(Long ordenId){
		return ordenRepository.findById(ordenId).get();
	}
	
	@Override
    public Iterable<Orden> obtenerOrdenesPorUsuarioId(Long usuarioId) {
        return ordenRepository.findByUsuarioId(usuarioId);
    }
    
	@Override
    public Orden guardarOrden(Long usuarioId, Orden orden) {
        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
            orden.setUsuario(usuario);
        });
        return ordenRepository.save(orden);
    }
    
	@Override
	public Orden actualizarOrden(Long ordenId, Orden ordenRequest) {
		ordenRepository.findById(ordenId).ifPresent(orden -> {
			orden.setReferencia(ordenRequest.getReferencia());
			orden.setFirma(ordenRequest.getFirma());
			orden.setTotal(ordenRequest.getTotal());
			ordenRepository.save(orden);
		});
		return ordenRepository.findById(ordenId).get();
	}
	
	@Override
    public void borrarOrden(Long ordenId) {
        ordenRepository.findById(ordenId).ifPresent(orden -> {
             ordenRepository.delete(orden);
        });
        return;
    }
    
}
