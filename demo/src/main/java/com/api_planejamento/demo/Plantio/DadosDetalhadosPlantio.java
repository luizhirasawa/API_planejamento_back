package com.api_planejamento.demo.Plantio;

public record DadosDetalhadosPlantio(
    Long id,
    String nome,
    Long id_cultura_anterior,
    Long id_planejamento
) {

}
