package com.api_planejamento.demo.Insumos;

import java.math.BigDecimal;

import jakarta.persistence.Enumerated;

public record DadosAtualizaInsumo(
    Long id,
    String nome,
    String codigo,
    String descricao,
    String principio_ativo,
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
