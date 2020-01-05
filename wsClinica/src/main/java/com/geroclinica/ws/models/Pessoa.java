package com.geroclinica.ws.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidade Pessoa
 * @author JONATHAN
 * @LastEdition 19/07/2019
 *  
 */
@Getter
@Setter
@Entity

@Table(name = "pessoa", schema = "clinica_gero")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "SQ_PESSOA", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_PESSOA", sequenceName = "clinica_gero" + ".SQ_PESSOA", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "DATA_NASC")
	private String dataNasc;

	@Column(name = "GENERO")
	private String genero;

	@Column(name = "TELEFONE")
	private String telefone;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Colaborador> colaborador;

	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Paciente> paciente;
}
