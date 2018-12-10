package com.unifacisa.lti.springSecurityExemplo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.lti.springSecurityExemplo.domains.entities.Usuario;
import com.unifacisa.lti.springSecurityExemplo.exceptions.AlreadyExistsException;
import com.unifacisa.lti.springSecurityExemplo.exceptions.ResourceNotFoundException;
import com.unifacisa.lti.springSecurityExemplo.services.UsuarioServ;


@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServ service;

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable String id) throws ResourceNotFoundException {
		return new ResponseEntity<Usuario>(service.getUsuario(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Usuario>> getUsuario() {
		return new ResponseEntity<List<Usuario>>(service.getAllUsuario(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) throws AlreadyExistsException {
		usuario = service.postUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario Usuario) throws ResourceNotFoundException {
		Usuario = service.putUsuario(Usuario);
		return new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable String id) throws ResourceNotFoundException {
		service.deleteUsuario(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
