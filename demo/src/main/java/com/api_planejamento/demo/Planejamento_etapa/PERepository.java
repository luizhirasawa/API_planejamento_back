package com.api_planejamento.demo.Planejamento_etapa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PERepository extends JpaRepository<PlanejamentoEtapa, Long>{
    
    List<PlanejamentoEtapa> findAllByAtivoTrue();

}
