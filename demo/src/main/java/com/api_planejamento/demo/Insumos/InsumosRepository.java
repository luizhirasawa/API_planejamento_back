package com.api_planejamento.demo.Insumos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsumosRepository extends JpaRepository<Insumo, Long>{

    List<Insumo> findAllByAtivoTrue();

}
