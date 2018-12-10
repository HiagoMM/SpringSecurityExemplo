package com.unifacisa.lti.springSecurityExemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.unifacisa.lti.springSecurityExemplo.domains.entities.Usuario;
import com.unifacisa.lti.springSecurityExemplo.exceptions.ResourceNotFoundException;

@Component
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioServ serv;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario= null;
		try {
			usuario = serv.getUsuario(username);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return new org.springframework.security.core.userdetails.User(usuario.getUsername(),usuario.getSenha(),usuario.getAuthorities());
	}
}
