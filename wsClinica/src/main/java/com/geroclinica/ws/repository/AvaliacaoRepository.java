package com.geroclinica.ws.repository;

import com.geroclinica.ws.models.Avaliacao;
import com.geroclinica.ws.models.Colaborador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {

    @Query(" SELECT a FROM Avaliacao a WHERE a.paciente.id = ?1 ")
    Avaliacao findByPaciente(long idPaciente);
}
