package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Especialidade;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.models.VinculoColaboradorPaciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO implements Serializable{

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String dataNasc;
	private String genero;
	private String situacao;
	private EnderecoDTO endereco;
	private EspecialidadeDTO especialidade;



	public ColaboradorDTO (Colaborador colaborador, Pessoa pessoa){
		this.id = colaborador.getId();
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.telefone = pessoa.getTelefone();
		this.dataNasc = pessoa.getDataNasc();
		this.genero = pessoa.getGenero();
		this.situacao = colaborador.getSituacao();
		this.endereco = new EnderecoDTO(pessoa.getEndereco());
		this.especialidade = new EspecialidadeDTO(colaborador.getEspecialidade());
	}

}
