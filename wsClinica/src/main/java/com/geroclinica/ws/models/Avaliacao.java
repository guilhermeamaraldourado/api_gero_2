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
@Table(name = "avaliacao_paciente", schema = "clinica_gero")
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "sq_avaliacao_paciente", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_avaliacao_paciente", sequenceName = "clinica_gero" + ".sq_avaliacao_paciente", initialValue = 1, allocationSize = 1)
	private Long id;


	@OneToOne
	@JoinColumn(name = "paciente")
	private Paciente paciente;

	@Column(name = "colaborador")
	private Long idColaborador;

	@Column(name = "frequencia")
	private String frequencia;

	@Column(name = "dsc_doenca")
	private String dscDoenca;

	@Column(name = "dsc_plano_tratamento")
	private String dscPlanoTratamento;

	@Column(name = "dsc_observacao")
	private String dscObservacao;

}
