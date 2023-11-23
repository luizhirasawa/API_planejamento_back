package com.api_planejamento.demo.Planejamento_etapa_insumo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PEIRepository extends JpaRepository<PlanejamentoEtapaInsumo, Long>{
    
    List<PlanejamentoEtapaInsumo> findAllByAtivoTrue();

}
