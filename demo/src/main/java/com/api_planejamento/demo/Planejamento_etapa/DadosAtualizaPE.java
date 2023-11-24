package com.api_planejamento.demo.Planejamento_etapa;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPE(
    @NotNull
    Long id,
    String nome_etapa,
    int numero_dias,
    @Enumerated(EnumType.STRING)
    StatusEtapa estado,
    Long id_planejamento
) {

}
