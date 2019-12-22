package com.geroclinica.ws.dto;

import com.geroclinica.ws.enuns.Status;
import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String dataNasc;
	private String genero;
	private String laudo;
	private String situacao;
	private String convenio;
	private EnderecoDTO endereco;

	public PacienteDTO(Paciente paciente, Pessoa pessoa){
		this.id = paciente.getId();
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.telefone = pessoa.getTelefone();
		this.dataNasc = pessoa.getDataNasc();
		this.genero = pessoa.getGenero();
		this.convenio = paciente.getConvenio();
		this.laudo = paciente.getLaudo();
		this.situacao = paciente.getSituacao();
		this.endereco = new EnderecoDTO(pessoa.getEndereco());
	}

}
