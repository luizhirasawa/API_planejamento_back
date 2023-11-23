package com.api_planejamento.demo.Planejamento_etapa;

public record DadosListagemPE(
    Long id,
    String codigo,
    String nome_etapa,
    int numero_dias,
    Status_Etapa estado,
    Long id_planejamneto
) {

    public DadosListagemPE(PlanejamentoEtapa tipos){
        this(tipos.getId(), tipos.getCodigo(), tipos.getNome_etapa(), tipos.getNumero_dias(), 
        tipos.getEstado(), tipos.getId_planejamento());
    }
}
