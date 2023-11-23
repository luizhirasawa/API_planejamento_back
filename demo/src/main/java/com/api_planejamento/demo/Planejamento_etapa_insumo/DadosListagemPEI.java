package com.api_planejamento.demo.Planejamento_etapa_insumo;

import jakarta.persistence.Enumerated;

public record DadosListagemPEI(
    Long id,
    @Enumerated
    Unidade unidade,
    int quantidade_ha,
    Long planejamento_etapa_id,
    Long id_cultura,
    Long id_insumo
) {

    public DadosListagemPEI(PlanejamentoEtapaInsumo PEI){
        this(PEI.getId(), PEI.getUnidade(), PEI.getQuantidade_ha(), PEI.getPlanejamento_etapa_id(),
        PEI.getId_cultura(), PEI.getId_insumo());
    }
}
