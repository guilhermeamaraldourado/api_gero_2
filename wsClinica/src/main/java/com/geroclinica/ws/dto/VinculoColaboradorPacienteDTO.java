package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VinculoColaboradorPacienteDTO{

	private Long id;
	private PacienteDTO paciente;
	private ColaboradorDTO colaborador;

	public VinculoColaboradorPacienteDTO(Long id, Paciente paciente, Colaborador colaborador){
		this.id = id;
		this.paciente = new PacienteDTO(paciente, paciente.getPessoa());
		this.colaborador = new ColaboradorDTO(colaborador, colaborador.getPessoa());
	}

}
