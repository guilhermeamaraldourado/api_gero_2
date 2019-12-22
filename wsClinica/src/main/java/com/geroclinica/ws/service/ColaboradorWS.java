package com.geroclinica.ws.service;

import com.geroclinica.ws.dto.ColaboradorDTO;
import com.geroclinica.ws.dto.PacienteDTO;
import com.geroclinica.ws.dto.PessoaDTO;
import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.repository.ColaboradorRepository;
import com.geroclinica.ws.repository.PacienteRepository;
import com.geroclinica.ws.repository.PessoaRepository;
import com.geroclinica.ws.statics.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        path = "/colaboradores",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class ColaboradorWS {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public Colaborador adicionar(@RequestBody Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

   @GetMapping
    public ResponseEntity<Iterable<ColaboradorDTO>> findAllPaciente() {
       Iterable<Colaborador> colaborador = colaboradorRepository.findAll();
       List<ColaboradorDTO> allcolaboradores = new ArrayList<>();


       for (Colaborador c: colaborador) {
           ColaboradorDTO dto = new ColaboradorDTO(c, c.getPessoa());
           allcolaboradores.add(dto);
       }
        return ResponseEntity.ok(allcolaboradores);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<ColaboradorDTO> findById(@RequestParam(value = "id") Long id){
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        Optional<Pessoa> pessoa = pessoaRepository.findById(colaborador.get().getPessoa().getId());
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO(colaborador.get(), pessoa.get());
        return ResponseEntity.ok(colaboradorDTO);
    }

    @GetMapping(value = "/cpf")
    public ResponseEntity<ColaboradorDTO> findByCpf(@RequestParam(value = "cpf") String cpf){
        if(cpf.isEmpty()){
            return new ResponseEntity(Message.CPF_NAO_PREENCHIDO, HttpStatus.BAD_REQUEST);
        }

        Pessoa pessoa = pessoaRepository.findByCPF(cpf);
        if(pessoa == null){
            return new ResponseEntity(Message.CPF_NAO_CADASTRADO, HttpStatus.BAD_REQUEST);
        }

        Colaborador colaborador = colaboradorRepository.findByIdPessoa(pessoa.getId());
        if(colaborador == null){
            return new ResponseEntity(Message.PACIENTE_NAO_ENCONTRADO_PACIENTE, HttpStatus.BAD_REQUEST);
        }

        ColaboradorDTO colaboradorDTO = new ColaboradorDTO(colaborador, pessoa);
        return ResponseEntity.ok(colaboradorDTO);
    }

    @GetMapping(value = "/nome")
    public ResponseEntity<ColaboradorDTO> findByNome(@RequestParam(value = "nome") String nome){
        if(nome.isEmpty()){
            return new ResponseEntity(Message.NOME_NAO_PREENCHIDO, HttpStatus.BAD_REQUEST);
        }

        Pessoa pessoa = pessoaRepository.findByNome(nome);
        if(pessoa == null){
            return new ResponseEntity(Message.NOME_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST);
        }

        Colaborador colaborador = colaboradorRepository.findByIdPessoa(pessoa.getId());
        if(colaborador == null){
            return new ResponseEntity(Message.NOME_NAO_PERTENCE_PACIENTE, HttpStatus.BAD_REQUEST);
        }

        ColaboradorDTO colaboradorDTO = new ColaboradorDTO(colaborador, pessoa);
        return ResponseEntity.ok(colaboradorDTO);
    }

}
