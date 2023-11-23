package com.api_planejamento.demo.Insumos;

import java.math.BigDecimal;

public record DadosListagemInsumo(
    
    Long id,
    String nome,
    String codigo,
    String descricao,
    String principio_ativo,
    String grupo,
    Classe subclasse,
    Fabricante fabricante,
    BigDecimal preco,
    Unidade unidade
) {
    public DadosListagemInsumo(Insumo insumo){
            this(insumo.getId(), insumo.getNome(), insumo.getCodigo(), insumo.getDescricao(), insumo.getPrincipio_ativo(), 
                insumo.getGrupo(), insumo.getSubclasse(), insumo.getFabricante(), insumo.getPreco(), insumo.getUnidade());
    }
}
