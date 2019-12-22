package com.geroclinica.ws.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

	ATIVO("A", "Ativo"),
	INATIVO("I", "Inativo");
	
	private String codigo;
	private String descricao;
		
}
