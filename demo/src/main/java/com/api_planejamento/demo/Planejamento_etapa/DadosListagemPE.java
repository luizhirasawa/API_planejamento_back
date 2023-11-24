package com.api_planejamento.demo.Planejamento_etapa;

public record DadosListagemPE(
    Long id,
    String nome_etapa,
    int numero_dias,
    StatusEtapa estado,
    Long id_planejamento
) {

    public DadosListagemPE(PlanejamentoEtapa PE){
        this(PE.getId(), PE.getNome_etapa(), PE.getNumero_dias(), 
        PE.getEstado(), PE.getId_planejamento());
    }
}
