package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

public class AvaliacaoDTO {

	private Long id;

	private Paciente paciente;

//	private Long idColaborador;

	private String frequencia;

	private String dscDoenca;

	private String dscPlanoTratamento;

	private String dscObservacao;

}
