package com.api_planejamento.demo.Planejamento;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroPlanejamento(
    @Positive
    int area_plantio,
    @NotBlank
    String nome_etapa,
    @Future
    LocalDate data_comeco,
    @Future
    LocalDate data_colheita,
    @NotNull
    Long id_cultura_anterior,
    @NotNull
    Long id_cultura
) {
    
}
