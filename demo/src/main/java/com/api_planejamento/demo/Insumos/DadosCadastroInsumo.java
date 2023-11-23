package com.api_planejamento.demo.Insumos;

import java.math.BigDecimal;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroInsumo(
    @NotBlank
    String nome,
    @NotBlank
    String codigo,
    @NotBlank
    String descricao,
    @NotBlank
    String principio_ativo,
    @NotBlank
    String grupo,
    @Enumerated
    Classe subclasse,
    @Enumerated
    Fabricante fabricante,
    BigDecimal preco,
    @Enumerated
    Unidade unidade
    ) {

}
