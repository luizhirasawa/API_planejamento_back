package com.api_planejamento.demo.Planejamento_etapa;

import jakarta.validation.constraints.NotNull;

public record DadosNomePE(
    @NotNull
    Long id,
    String nome_etapa
) {
    public DadosNomePE(PlanejamentoEtapa PE){
        this(PE.getId(), PE.getNome_etapa());
    }
}
