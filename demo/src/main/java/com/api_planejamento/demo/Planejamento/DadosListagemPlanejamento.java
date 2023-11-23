package com.api_planejamento.demo.Planejamento;

import java.time.LocalDate;

public record DadosListagemPlanejamento(
    long id,
    int area_plantio,
    String nome_etapa,
    LocalDate data_comeco,
    LocalDate data_colheita,
    Long id_cultura_anterior,
    Long id_cultura
) {
    public DadosListagemPlanejamento(Planejamento planejamento){
        this(planejamento.getId(), planejamento.getArea_plantio(), planejamento.getNome_etapa(), planejamento.getData_comeco(),
        planejamento.getData_colheita(), planejamento.getId_cultura_anterior(), planejamento.getId_cultura());
    }
}
