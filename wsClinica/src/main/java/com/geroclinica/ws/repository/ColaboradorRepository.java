package com.geroclinica.ws.repository;

import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Especialidade;
import com.geroclinica.ws.models.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long>{

	@Query(" SELECT c FROM Colaborador c WHERE c.id = ?1 ")
	Colaborador findByMatricula(long matricula);

	@Query(" SELECT c FROM Colaborador c WHERE c.especialidade = ?1 ")
	Colaborador findByEspecialidade(Especialidade especialidade);

	@Query("SELECT c FROM Colaborador c WHERE c.pessoa.id = ?1")
	Colaborador findByIdPessoa(long id);


}
