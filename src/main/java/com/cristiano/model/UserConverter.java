package com.cristiano.model;

import javax.persistence.AttributeConverter;

@javax.persistence.Converter
public class UserConverter implements AttributeConverter<Nome, String> {

	@Override
	public String convertToDatabaseColumn(Nome nome) {
		if(nome == null){
			return null;
		}
		return nome.getNome();
	}

	@Override
	public Nome convertToEntityAttribute(String str) {
		if(str == null){
			str = "";
		}
		return new Nome(str);
	}

}