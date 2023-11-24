package com.api_planejamento.demo.Planejamento;

import jakarta.validation.constraints.NotNull;

public record DadosNomePlanejamento(
    @NotNull
    Long id,
    String nome_etapa
) {
    public DadosNomePlanejamento(Planejamento planejamento){
        this(planejamento.getId(), planejamento.getNome_etapa());
    }
}
