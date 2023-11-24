package com.api_planejamento.demo.Planejamento_etapa;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPE(
    @NotBlank
    String nome_etapa,
    int numero_dias,
    @Enumerated(EnumType.STRING)
    StatusEtapa estado,
    @NotNull
    Long id_planejamento
) {

}
