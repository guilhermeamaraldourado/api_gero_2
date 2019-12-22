package com.geroclinica.ws.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "v_paciente_colaborador" , schema = "clinica_gero")
public class VinculoColaboradorPaciente implements Serializable{

	/**
	 * Entidade Especialidade
	 * @author JONATHAN
	 * @LastEdition 06/10/2019
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "SQ_V_PACIENTE_COLABORADOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_V_PACIENTE_COLABORADOR", sequenceName = "clinica_gero" + ".SQ_V_PACIENTE_COLABORADOR", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente", referencedColumnName = "id")
	private Paciente paciente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colaborador", referencedColumnName = "id")
	private Colaborador colaborador;
}
