package com.api_planejamento.demo.Insumos;

import jakarta.validation.constraints.NotNull;

public record DadosNomeInsumo(
    @NotNull
    Long id,
    String nome
) {
    public DadosNomeInsumo(Insumo PE){
        this(PE.getId(), PE.getNome());
    }
}
