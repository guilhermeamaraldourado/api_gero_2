package com.geroclinica.ws.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.geroclinica.ws.models.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	@Query("SELECT p1 FROM Pessoa p1 WHERE p1.nome = ?1 ")
	Pessoa findByNome(String pessoa);
	
	@Query("SELECT p1 FROM Pessoa p1 WHERE p1.cpf = ?1 ")
	Pessoa findByCPF(String cpf);
	

}
