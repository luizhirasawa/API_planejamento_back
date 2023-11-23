package com.api_planejamento.demo.Planejamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanejamentoRepository extends JpaRepository<Planejamento, Long>{
    
    List<Planejamento> findAllByAtivoTrue();

}
