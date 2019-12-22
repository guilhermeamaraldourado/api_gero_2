package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Endereco;
import com.geroclinica.ws.models.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaDTO {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String dataNasc;
	private String genero;
	private String telefone;
	private EnderecoDTO enderecoDTO;

	public PessoaDTO (Pessoa pessoa){
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.cpf = pessoa.getCpf();
		this.dataNasc = pessoa.getDataNasc();
		this.genero = pessoa.getGenero();
		this.telefone = pessoa.getTelefone();
		//this.endereco = new EnderecoDTO();
	}

}
