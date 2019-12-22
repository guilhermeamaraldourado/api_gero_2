package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

	private Long id;
	private Integer cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String complemento;
	private Integer numero;

	public EnderecoDTO (Endereco endereco){
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.complemento = endereco.getComplemento();
		this.numero = endereco.getNumero();
	}

}
