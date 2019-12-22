package com.geroclinica.ws.repository;

import com.geroclinica.ws.models.Especialidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Long> {

    @Query(" SELECT e FROM Especialidade e WHERE e.id = ?1 ")
    Especialidade findById(long id);
}
