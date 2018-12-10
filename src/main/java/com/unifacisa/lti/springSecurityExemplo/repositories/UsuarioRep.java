package com.unifacisa.lti.springSecurityExemplo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.lti.springSecurityExemplo.domains.entities.Usuario;

@Repository
public interface UsuarioRep extends MongoRepository<Usuario, String>{
}
