package com.geroclinica.ws.repository;

import com.geroclinica.ws.models.Avaliacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {

}
