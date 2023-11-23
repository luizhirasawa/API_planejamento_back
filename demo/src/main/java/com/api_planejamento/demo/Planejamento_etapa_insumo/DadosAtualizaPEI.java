package com.api_planejamento.demo.Planejamento_etapa_insumo;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPEI(
    @NotNull
    Long id,
    @Enumerated
    Unidade unidade,
    int quantidade_ha,
    Long planejamento_etapa_id,
    Long id_cultura,
    Long id_insumo
) {

}
