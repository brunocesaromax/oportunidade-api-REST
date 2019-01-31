package com.oportunidade.oportunidadeapi.Repository;


import com.oportunidade.oportunidadeapi.Model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*Implementação em tempo de execução*/
public interface OportunidadeRepository extends JpaRepository<Oportunidade,Long> {

    /*Busca combinada pelo spring-data, sem precisar de implementação*/
    Optional<Oportunidade> findByDescricaoAndAndNomeProspecto(String descricao, String nomeProspecto);
}
