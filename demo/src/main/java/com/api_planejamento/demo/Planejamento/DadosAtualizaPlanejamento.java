package com.api_planejamento.demo.Planejamento;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPlanejamento(
    @NotNull
    long id,
    int area_plantio,
    String nome_etapa,
    LocalDate data_comeco,
    LocalDate data_colheita,
    Long id_cultura_anterior,
    Long id_cultura
) {

}
