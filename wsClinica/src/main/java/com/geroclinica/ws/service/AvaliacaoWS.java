package com.geroclinica.ws.service;

import com.geroclinica.ws.dto.AvaliacaoDTO;
import com.geroclinica.ws.dto.VinculoColaboradorPacienteDTO;
import com.geroclinica.ws.models.Avaliacao;
import com.geroclinica.ws.repository.AvaliacaoRepository;
import com.geroclinica.ws.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/avaliacao",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class AvaliacaoWS {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

   @GetMapping
    public ResponseEntity<Iterable<AvaliacaoDTO>> findAllAvaliacao() {
       Iterable<Avaliacao> vinculo = avaliacaoRepository.findAll();
       return ResponseEntity.ok(getVinculoColaboradorPacienteDTO(vinculo));
    }
//
//    @GetMapping(value = "/id")
//    public ResponseEntity<VinculoColaboradorPacienteDTO> findById(@RequestParam(value = "id") Long id){
//        Optional<VinculoColaboradorPaciente> vinculo = vinculoRepository.findById(id);
//        return ResponseEntity.ok(new VinculoColaboradorPacienteDTO(vinculo.get().getId(), vinculo.get().getPaciente(), vinculo.get().getColaborador()));
//    }
//
//    @GetMapping(value = "/idColaborador")
//    public ResponseEntity<Iterable<VinculoColaboradorPacienteDTO>> findByIdColaborador(@RequestParam(value = "idColaborador") Long idColaborador){
//        Iterable<VinculoColaboradorPaciente> vinculo = vinculoRepository.findByIdColaborador(idColaborador);
//        return ResponseEntity.ok(getVinculoColaboradorPacienteDTO(vinculo));
//    }
//
//    private Iterable<VinculoColaboradorPacienteDTO> getVinculoColaboradorPacienteDTO(Iterable<VinculoColaboradorPaciente> vinculo) {
//        List<VinculoColaboradorPacienteDTO> allVinculo = new ArrayList<>();
//        for (VinculoColaboradorPaciente v: vinculo) {
//            allVinculo.add(new VinculoColaboradorPacienteDTO(v.getId(), v.getPaciente(), v.getColaborador()));
//        }
//        return allVinculo;
//    }
}
