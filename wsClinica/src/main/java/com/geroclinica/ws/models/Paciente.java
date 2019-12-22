package com.geroclinica.ws.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.geroclinica.ws.enuns.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidade Paciente
 * @author JONATHAN
 * @LastEdition 19/07/2019
 */

@Getter
@Setter
@Entity
@Table(name = "paciente", schema = "clinica_gero")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "SQ_PACIENTE", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_PACIENTE", sequenceName = "clinica_gero" + ".SQ_PACIENTE", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "LAUDO")
	private String laudo;

	@Column(name = "SITUACAO")
	private String situacao;

	@Column(name = "CONVENIO")
	private String convenio;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "PESSOA")
	private Long idPessoa;

}
