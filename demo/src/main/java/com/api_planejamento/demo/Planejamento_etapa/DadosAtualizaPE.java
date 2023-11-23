package com.api_planejamento.demo.Planejamento_etapa;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPE(
    @NotNull
    Long id,
    String codigo,
    String nome_etapa,
    int numero_dias,
    @Enumerated
    Status_Etapa estado,
    Long id_planejamneto
) {

}
