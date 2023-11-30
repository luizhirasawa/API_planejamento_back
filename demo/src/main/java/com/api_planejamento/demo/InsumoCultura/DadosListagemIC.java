package com.api_planejamento.demo.InsumoCultura;

import jakarta.validation.constraints.NotNull;

public record DadosListagemIC(
    @NotNull
    Long id,
    int quantidade_ha,
    Long id_cultura,
    Long id_insumo
) {

    public DadosListagemIC(InsumoCultura PEI){
        this(PEI.getId(), PEI.getQuantidade_ha(),
        PEI.getId_cultura(), PEI.getId_insumo());
    }

}
