package com.unifacisa.lti.springSecurityExemplo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caderno")
public class Caderno {
	
	@GetMapping("/")
	public String getCaderno() {
		return "Funcionou !! ";
	}
	
}
