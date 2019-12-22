package com.geroclinica.ws.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "especialidade", schema = "clinica_gero")
public class Especialidade implements Serializable{

	/**
	 * Entidade Especialidade
	 * @author JONATHAN
	 * @LastEdition 06/10/2019
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "SQ_ESPECIALIDADE", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_ESPECIALIDADE", sequenceName = "clinica_gero" + ".SQ_ESPECIALIDADE", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@OneToMany(mappedBy = "especialidade")
	private List<Colaborador> colaborador;



}
