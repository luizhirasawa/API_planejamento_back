package com.api_planejamento.demo.Cultura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CulturaRepository extends JpaRepository<Cultura, Long>{
    
    List<Cultura> findAllByAtivoTrue();
    
}
