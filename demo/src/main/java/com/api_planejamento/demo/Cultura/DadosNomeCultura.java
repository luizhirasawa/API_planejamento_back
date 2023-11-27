package com.api_planejamento.demo.Cultura;

import jakarta.validation.constraints.NotNull;

public record DadosNomeCultura(
    @NotNull
    Long id,
    String nome
) {
    public DadosNomeCultura(Cultura PE){
        this(PE.getId(), PE.getNome());
    }
}
