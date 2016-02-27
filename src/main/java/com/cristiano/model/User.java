package com.cristiano.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Convert(converter = UserConverter.class)
	private Nome nome;
	
	public User() {
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	


	public User(Long id, String login, String password, Nome nome) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Nome getNome() {
		return nome;
	}

	public void setNome(Nome nome) {
		this.nome = nome;
	}

}
