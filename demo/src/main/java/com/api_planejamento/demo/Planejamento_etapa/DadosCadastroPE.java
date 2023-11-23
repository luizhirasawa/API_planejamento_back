package com.api_planejamento.demo.Planejamento_etapa;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPE(
    @NotBlank
    String codigo,
    @NotBlank
    String nome_etapa,
    int numero_dias,
    @Enumerated
    Status_Etapa estado,
    @NotNull
    Long id_planejamneto
) {

}
