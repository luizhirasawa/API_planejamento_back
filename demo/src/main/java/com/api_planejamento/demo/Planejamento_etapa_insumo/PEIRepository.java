package com.api_planejamento.demo.Planejamento_etapa_insumo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PEIRepository extends JpaRepository<PlanejamentoEtapaInsumo, Long>{
    
    List<PlanejamentoEtapaInsumo> findAllByAtivoTrue();

    @Query("SELECT i.nome, i.preco, pei.quantidade_ha, p.area_plantio " +
        "FROM Insumo i " +
        "JOIN PEI pei ON pei.id_insumo = i.id " +
        "JOIN PE pe ON pei.planejamento_etapa_id = pe.id " +
        "JOIN Planejamento p ON pe.id_planejamento = p.id " +
        "JOIN Plantio pl ON p.id = pl.id_planejamento " +
        "WHERE p.id = :idPlantio"
    )List<Object[]> consultarDadosInsumosPlanejamento(
        @Param("idPlantio") Long idPlantio
    );

    @Query("SELECT i, pei, p, pl " +
        "FROM Insumo i " +
        "JOIN PEI pei ON pei.id_insumo = i.id " +
        "JOIN PE pe ON pei.planejamento_etapa_id = pe.id " +
        "JOIN Planejamento p ON pe.id_planejamento = p.id " +
        "JOIN Plantio pl ON p.id = pl.id_planejamento " +
        "WHERE p.id = :idPlantio"
    )List<Object[]> consultarDadosInsumosPreco(
        @Param("idPlantio") Long idPlantio
    );

    @Query(
        "select i.nome, ((i.preco * pei.quantidade_ha)/p.area_plantio) as Custo " + 
        "FROM Insumo i " +
        "JOIN PEI pei ON pei.id_insumo = i.id " +
        "JOIN PE pe ON pei.planejamento_etapa_id = pe.id " +
        "JOIN Planejamento p ON pe.id_planejamento = p.id " +
        "JOIN Plantio pl ON p.id = pl.id_planejamento " +
        "WHERE p.id = :idPlantio"
    )List<Object[]> consultarDadosCustoInsumo(
        @Param("idPlantio") Long idPlantio
    );

}
