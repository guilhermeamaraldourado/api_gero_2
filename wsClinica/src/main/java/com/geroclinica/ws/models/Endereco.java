package com.geroclinica.ws.models;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade Pessoa
 * @author JONATHAN
 * @LastEdition 04/08/2019
 *  
 */

@Getter
@Setter
@Entity
@Table(name = "endereco", schema = "clinica_gero")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "SQ_ENDERECO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "clinica_gero" + ".SQ_ENDERECO", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "CEP")
	private Integer cep;

	@Column(name = "RUA")
	private String rua;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "NUMERO")
	private Integer numero;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;
}
