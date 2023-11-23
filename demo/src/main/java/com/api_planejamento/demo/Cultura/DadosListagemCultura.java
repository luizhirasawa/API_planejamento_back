package com.api_planejamento.demo.Cultura;

import java.math.BigDecimal;

public record DadosListagemCultura(
    Long id,
    String nome,
    BigDecimal preco_venda,
    String embalagem_venda
) {
    public DadosListagemCultura(Cultura cultura){
            this(cultura.getId(), cultura.getNome(), cultura.getPreco_venda(), cultura.getEmbalagem_venda());
    }
}
