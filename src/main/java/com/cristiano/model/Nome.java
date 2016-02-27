package com.cristiano.model;

public class Nome {
	
	private String nome;
	
	public Nome() {
	}
	
	public Nome(String nome) {
		this.nome = nome;
	}

	public String getNome(){
		return nome.toUpperCase();
	}
	

}
