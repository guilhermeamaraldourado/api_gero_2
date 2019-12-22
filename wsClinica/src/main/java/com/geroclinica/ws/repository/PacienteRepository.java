package com.geroclinica.ws.repository;

import com.geroclinica.ws.models.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PacienteRepository extends CrudRepository<Paciente, Long>{

    @Query("SELECT p FROM Paciente p WHERE p.idPessoa = ?1")
    Paciente findByIdPessoa(long id);
}
