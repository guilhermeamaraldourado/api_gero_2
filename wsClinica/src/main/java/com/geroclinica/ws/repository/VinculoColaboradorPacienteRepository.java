package com.geroclinica.ws.repository;

import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.VinculoColaboradorPaciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VinculoColaboradorPacienteRepository extends CrudRepository<VinculoColaboradorPaciente, Long>{


    @Query(" SELECT v FROM VinculoColaboradorPaciente v WHERE v.paciente = ?1 ")
    List<VinculoColaboradorPaciente> findByIdPciente(Paciente paciente);

}
