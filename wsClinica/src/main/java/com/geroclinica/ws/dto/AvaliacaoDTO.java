package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class AvaliacaoDTO {

	private Long id;

	private PacienteDTO paciente;

//	private Long idColaborador;

	private String frequencia;

	private String dscDoenca;

	private String dscPlanoTratamento;

	private String dscObservacao;

	public AvaliacaoDTO (Long id, Paciente paciente, String frequencia, String dscDoenca, String dscPlanoTratamento, String dscObservacao){
		this.id = id;
		this.paciente =  new PacienteDTO(paciente, paciente.getPessoa());
		this.frequencia = frequencia;
		this.dscDoenca = dscDoenca;
		this.dscPlanoTratamento = dscPlanoTratamento;
		this.dscObservacao = dscObservacao;
	}

}
