package com.geroclinica.ws.statics;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    public static final String IS_VAZIO = " ERRO: Objeto não pode ser vazio";
    public static final String CPF_NAO_PREENCHIDO = " ERRO: CPF obrigatório para a pesquisa";
    public static final String CPF_NAO_CADASTRADO = " ERRO: CPF não cadastrado";
    public static final String PACIENTE_NAO_ENCONTRADO_PACIENTE = " ERRO: Não existe paciente com o CPF Informado";
    public static final String NOME_NAO_PREENCHIDO = " ERRO: Nome obrigatório para a pesquisa";
    public static final String NOME_PACIENTE_NAO_ENCONTRADO = " ERRO: Paciente não encontrado com esse nome";
    public static final String NOME_NAO_PERTENCE_PACIENTE = " ERRO: Nome não pertence a um paciente";

}
