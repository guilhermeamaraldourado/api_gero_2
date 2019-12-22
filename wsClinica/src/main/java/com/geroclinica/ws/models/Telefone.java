package com.geroclinica.ws.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Telefone implements Serializable {

    /**
     * Entidade Telefone
     *
     * @author JONATHAN
     * @LastEdition 06/10/2019
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_TELEFONE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "clinica_gero" + ".SQ_TELEFONE", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "DDD")
    private String ddd;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "PESSOA")
    private Long idPessoa;

}
