package com.geroclinica.ws.service;

import com.geroclinica.ws.dto.AvaliacaoDTO;
import com.geroclinica.ws.dto.VinculoColaboradorPacienteDTO;
import com.geroclinica.ws.models.Avaliacao;
import com.geroclinica.ws.models.VinculoColaboradorPaciente;
import com.geroclinica.ws.repository.AvaliacaoRepository;
import com.geroclinica.ws.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
       Iterable<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
       return ResponseEntity.ok(getAvaliacoes(avaliacoes));
    }

    @GetMapping(value = "/id")
    public ResponseEntity<AvaliacaoDTO> findById(@RequestParam(value = "id") Long id){
        Optional<Avaliacao> a = avaliacaoRepository.findById(id);
        return ResponseEntity.ok(new AvaliacaoDTO(a.get().getId(), a.get().getPaciente(),
                                                  a.get().getFrequencia(), a.get().getDscDoenca(),
                                                  a.get().getDscPlanoTratamento(), a.get().getDscObservacao()));
    }

    @GetMapping(value = "/idPaciente")
    public ResponseEntity<AvaliacaoDTO> findByIdPaciente(@RequestParam(value = "idPaciente") Long idPaciente){
        Avaliacao a = avaliacaoRepository.findByPaciente(idPaciente);
        return ResponseEntity.ok(new AvaliacaoDTO(a.getId(), a.getPaciente(),
                                                  a.getFrequencia(), a.getDscDoenca(),
                                                  a.getDscPlanoTratamento(), a.getDscObservacao()));
    }

    private Iterable<AvaliacaoDTO> getAvaliacoes(Iterable<Avaliacao> avaliacao) {
        List<AvaliacaoDTO> all = new ArrayList<>();
        for (Avaliacao a: avaliacao) {
            all.add(new AvaliacaoDTO(a.getId(), a.getPaciente(), a.getFrequencia(), a.getDscDoenca(),
                                        a.getDscPlanoTratamento(), a.getDscObservacao()));
        }
        return all;
    }
}
