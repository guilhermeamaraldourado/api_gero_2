package com.geroclinica.ws.service;

import com.geroclinica.ws.dto.ColaboradorDTO;
import com.geroclinica.ws.dto.VinculoColaboradorPacienteDTO;
import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.models.VinculoColaboradorPaciente;
import com.geroclinica.ws.repository.ColaboradorRepository;
import com.geroclinica.ws.repository.PessoaRepository;
import com.geroclinica.ws.repository.VinculoColaboradorPacienteRepository;
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
        path = "/vinculo",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class VinculoWS {

    @Autowired
    VinculoColaboradorPacienteRepository vinculoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

   @GetMapping
    public ResponseEntity<Iterable<VinculoColaboradorPacienteDTO>> findAllVinculo() {
       Iterable<VinculoColaboradorPaciente> vinculo = vinculoRepository.findAll();
       return ResponseEntity.ok(getVinculoColaboradorPacienteDTO(vinculo));
    }

    @GetMapping(value = "/id")
    public ResponseEntity<VinculoColaboradorPacienteDTO> findById(@RequestParam(value = "id") Long id){
        Optional<VinculoColaboradorPaciente> vinculo = vinculoRepository.findById(id);
        return ResponseEntity.ok(new VinculoColaboradorPacienteDTO(vinculo.get().getId(), vinculo.get().getPaciente(), vinculo.get().getColaborador()));
    }

    @GetMapping(value = "/idColaborador")
    public ResponseEntity<Iterable<VinculoColaboradorPacienteDTO>> findByIdColaborador(@RequestParam(value = "idColaborador") Long idColaborador){
        Iterable<VinculoColaboradorPaciente> vinculo = vinculoRepository.findByIdColaborador(idColaborador);
        return ResponseEntity.ok(getVinculoColaboradorPacienteDTO(vinculo));
    }

    private Iterable<VinculoColaboradorPacienteDTO> getVinculoColaboradorPacienteDTO(Iterable<VinculoColaboradorPaciente> vinculo) {
        List<VinculoColaboradorPacienteDTO> allVinculo = new ArrayList<>();
        for (VinculoColaboradorPaciente v: vinculo) {
            allVinculo.add(new VinculoColaboradorPacienteDTO(v.getId(), v.getPaciente(), v.getColaborador()));
        }
        return allVinculo;
    }
}
