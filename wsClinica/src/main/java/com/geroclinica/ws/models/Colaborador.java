package com.geroclinica.ws.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "colaborador", schema = "clinica_gero")
public class Colaborador implements Serializable{

	/**
	 * Entidade Colaborador
	 * @author JONATHAN
	 * @LastEdition 19/07/2019 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "SQ_COLABORADOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_COLABORADOR", sequenceName = "clinica_gero" + ".SQ_COLABORADOR", initialValue = 1, allocationSize = 1)
	private Long id;
//
//	@Column(name = )
//	private String setor;

	@Column(name = "situacao")
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "pessoa", referencedColumnName = "id")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "especialidade", referencedColumnName = "id")
	private Especialidade especialidade;

}
