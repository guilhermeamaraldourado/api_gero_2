package com.geroclinica.ws.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {

	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminio");
	
	private String codigo;
	private String descricao;
		
}
