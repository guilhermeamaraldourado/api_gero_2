package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeDTO implements Serializable{

	private Long id;

	private String nome;

	public EspecialidadeDTO (Especialidade especialidade){
		this.id = especialidade.getId();
		this.nome = especialidade.getNome();

	}
}
