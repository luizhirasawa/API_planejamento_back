package com.api_planejamento.demo.Plantio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantioRepository extends JpaRepository<Plantio, Long> {
    
    List<Plantio> findAllByAtivoTrue();
}
