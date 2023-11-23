package com.api_planejamento.demo.Plantio;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPlantio(
    @NotNull
    Long id,
    String nome,
    Long id_cultura_anterior,
    Long id_planejamento) {

}
