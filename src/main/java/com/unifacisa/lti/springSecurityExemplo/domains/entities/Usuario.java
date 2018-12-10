package com.unifacisa.lti.springSecurityExemplo.domains.entities;

import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Document
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull(message="{Atributo.Nulo}")
	private String username;
	@NotNull(message="{Atributo.Nulo}")
	private String senha;
	@NotNull(message="{Atributo.Nulo}")
	private FuncoesEnum funcao;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> permiAdm = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		List<GrantedAuthority> permiBasico = AuthorityUtils.createAuthorityList("ROLE_BASICO");
		
		List<GrantedAuthority> permi = null;
		if (this.getFuncao().isAdmin()) {
			permi = permiAdm;
		}else if (this.getFuncao().isBasico()) {
			permi = permiBasico;
		}
		return permi;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public FuncoesEnum getFuncao() {
		return funcao;
	}
	public void setFuncao(FuncoesEnum funcao) {
		this.funcao = funcao;
	}
}
