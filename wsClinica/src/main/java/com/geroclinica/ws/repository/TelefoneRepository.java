package com.geroclinica.ws.repository;

import com.geroclinica.ws.models.Telefone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TelefoneRepository extends CrudRepository<Telefone, Long>{


}
