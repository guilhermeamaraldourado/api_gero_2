package com.geroclinica.ws.service;

import com.geroclinica.ws.dto.PacienteDTO;
import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;
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
        path = "/pacientes",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class PacienteWS {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public Paciente adicionar(@RequestBody Paciente paciente){
        return pacienteRepository.save(paciente);
    }

   @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAllPaciente(){
        Iterable<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> allPacientes = new ArrayList<>();

       for (Paciente p: pacientes) {
           Optional<Pessoa> pessoa = pessoaRepository.findById(p.getPessoa().getId());
           PacienteDTO pacienteDTO = new PacienteDTO(p, pessoa.get());
           allPacientes.add(pacienteDTO);
       }
        return ResponseEntity.ok(allPacientes);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<PacienteDTO> findById(@RequestParam(value = "id") Long id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        Optional<Pessoa> pessoa = pessoaRepository.findById(paciente.get().getPessoa().getId());
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.get(), pessoa.get());
        return ResponseEntity.ok(pacienteDTO);
    }

    @GetMapping(value = "/cpf")
    public ResponseEntity<PacienteDTO> findByCpf(@RequestParam(value = "cpf") String cpf){
        if(cpf.isEmpty()){
            return new ResponseEntity(Message.CPF_NAO_PREENCHIDO, HttpStatus.BAD_REQUEST);
        }

        Pessoa pessoa = pessoaRepository.findByCPF(cpf);
        if(pessoa == null){
            return new ResponseEntity(Message.CPF_NAO_CADASTRADO, HttpStatus.BAD_REQUEST);
        }

        Paciente paciente = pacienteRepository.findByIdPessoa(pessoa.getId());
        if(paciente == null){
            return new ResponseEntity(Message.PACIENTE_NAO_ENCONTRADO_PACIENTE, HttpStatus.BAD_REQUEST);
        }

        PacienteDTO pacienteDTO = new PacienteDTO(paciente, pessoa);
        return ResponseEntity.ok(pacienteDTO);
    }

    @GetMapping(value = "/nome")
    public ResponseEntity<PacienteDTO> findByNome(@RequestParam(value = "nome") String nome){
        if(nome.isEmpty()){
            return new ResponseEntity(Message.NOME_NAO_PREENCHIDO, HttpStatus.BAD_REQUEST);
        }

        Pessoa pessoa = pessoaRepository.findByNome(nome);
        if(pessoa == null){
            return new ResponseEntity(Message.NOME_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST);
        }

        Paciente paciente = pacienteRepository.findByIdPessoa(pessoa.getId());
        if(paciente == null){
            return new ResponseEntity(Message.NOME_NAO_PERTENCE_PACIENTE, HttpStatus.BAD_REQUEST);
        }

        PacienteDTO pacienteDTO = new PacienteDTO(paciente, pessoa);
        return ResponseEntity.ok(pacienteDTO);
    }

}
