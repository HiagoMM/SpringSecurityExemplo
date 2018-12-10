package com.unifacisa.lti.springSecurityExemplo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.lti.springSecurityExemplo.domains.entities.Usuario;
import com.unifacisa.lti.springSecurityExemplo.exceptions.AlreadyExistsException;
import com.unifacisa.lti.springSecurityExemplo.exceptions.ResourceNotFoundException;
import com.unifacisa.lti.springSecurityExemplo.repositories.UsuarioRep;

@Service
public class UsuarioServ {
	
	@Autowired
	private UsuarioRep repository;
	
	public Usuario postUsuario(Usuario usuario) throws AlreadyExistsException {
		if (!repository.existsById(usuario.getUsername())) {
			return repository.save(usuario);
		}throw new AlreadyExistsException("User :"+usuario.getUsername()+" Already exists");
	}
	
	public Usuario putUsuario(Usuario usuario) throws ResourceNotFoundException {
		if (repository.existsById(usuario.getUsername())) {
			return repository.save(usuario);
		}
		throw new ResourceNotFoundException("User :"+usuario.getUsername()+" not exists");
	}

	public Usuario getUsuario(String id) throws ResourceNotFoundException {
		if (repository.existsById(id)) {
			return repository.findById(id).get();
		}throw new ResourceNotFoundException("id :"+id+" not exists");
	}
	
	public List<Usuario> getAllUsuario(){
		return repository.findAll();
	}
	
	public void deleteUsuario(String username ) throws ResourceNotFoundException {
		if (!repository.existsById(username)) {
			throw new ResourceNotFoundException("User :"+username+" not exists");
		}repository.deleteById(username);
	}
	

}
