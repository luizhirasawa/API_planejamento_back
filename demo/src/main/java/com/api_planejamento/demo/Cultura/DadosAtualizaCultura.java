package com.api_planejamento.demo.Cultura;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCultura(
    @NotNull
    Long id,
    String nome,
    BigDecimal preco_venda,
    String embalagem_venda
) {

}
