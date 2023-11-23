package com.api_planejamento.demo.Cultura;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCultura(
    @NotBlank
    String nome,
    @NotNull
    BigDecimal preco_venda,
    @NotBlank
    String embalagem_venda
) {
    
}
