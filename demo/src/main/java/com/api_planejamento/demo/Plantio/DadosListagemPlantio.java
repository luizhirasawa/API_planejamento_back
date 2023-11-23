package com.api_planejamento.demo.Plantio;

public record DadosListagemPlantio(
    Long id,
    String nome,
    Long id_cultura_anterior,
    Long id_planejamento) {

        public DadosListagemPlantio(Plantio plantio){
            this(plantio.getId(), plantio.getNome(), plantio.getId_cultura_anterior(), plantio.getId_planejamento());
        }
}
