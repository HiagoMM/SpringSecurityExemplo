package com.unifacisa.lti.springSecurityExemplo.domains.entities;


public enum FuncoesEnum {
	
	ADMIN(0) {
		public boolean isAdmin() {
			return true;
		}	
	},
	BASICO(1){
		public boolean isBasico() {
			return true;
		}
	};

	Integer value;

	FuncoesEnum(Integer value) {
		this.value = value;
	}

	public boolean isAdmin() {
		return false;
	}

	public boolean isBasico() {
		return false;
	}
}
