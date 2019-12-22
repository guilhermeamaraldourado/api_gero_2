package com.geroclinica.ws.validacao;


import com.geroclinica.ws.models.Endereco;
import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;

public class UtilsValidacao {
	
	public Boolean validaCamposPaciente(Paciente paciente) {
		if(paciente.getLaudo().isEmpty()) {
			return false;
		}
		else if(paciente.getSituacao().isEmpty()) {
			return false;
		}
//		if (!validaCamposPessoa(paciente.getPessoa())) {
//			return false;
//		}
//		else if(!validaCamposEndereco(paciente.getPessoa().getEndereco())) {
//			return false;
//		}
		return true;
	}

	private Boolean validaCamposEndereco(Endereco endereco) {
		if(endereco.getCep()== null) {
			return false;
		}
		else if(endereco.getRua().isEmpty()) {
			return false;
		}
		else if(endereco.getBairro().isEmpty()) {
			return false;
		}
		else if(endereco.getCidade().isEmpty()) {
			return false;
		}
		else if(endereco.getComplemento().isEmpty()) {
			return false;
		}
		else if(endereco.getNumero() == null) {
			return false;
		}
		return true;
	}

	private Boolean validaCamposPessoa(Pessoa pessoa) {
		if(pessoa.getNome().isEmpty()) {
			return false;
		}
		else if(pessoa.getCpf().isEmpty()) {
			return false;
		}
		else if(pessoa.getDataNasc() == null) {
			return false;
		}
		else if(pessoa.getTelefone() == null) {
			return false;
		}
		else if(pessoa.getGenero() == null) {
			return false;
		}	
		
		return true;
	}

}
