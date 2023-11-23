package com.api_planejamento.demo.Plantio;

public record DadosCadastroPlantio(
    String nome,
    Long id_cultura_anterior,
    Long id_planejamento
) {

}
