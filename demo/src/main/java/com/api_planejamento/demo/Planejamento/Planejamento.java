package com.api_planejamento.demo.Planejamento;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Planejamento")
@Table(name = "planejamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Planejamento {
    
    public Planejamento(DadosCadastroPlanejamento dados){
        this.area_plantio = dados.area_plantio();
        this.nome_etapa = dados.nome_etapa();
        this.data_comeco = dados.data_comeco();
        this.data_colheita = dados.data_colheita();
        this.id_cultura_anterior = dados.id_cultura_anterior();
        this.id_cultura = dados.id_cultura();
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int area_plantio;
    private String nome_etapa;
    private LocalDate data_comeco;
    private LocalDate data_colheita;
    private Long id_cultura_anterior;
    private Long id_cultura;
    private boolean ativo;

    public void atualizarInfos(@Valid DadosAtualizaPlanejamento dados) {
        if(dados.area_plantio() > 0){
            this.area_plantio = dados.area_plantio();
        }
        if(dados.nome_etapa() != null){
            this.nome_etapa = dados.nome_etapa();
        }
        if(dados.data_comeco() != null){
            this.data_comeco = dados.data_comeco();
        }
        if(dados.data_colheita() != null){
            this.data_colheita = dados.data_colheita();
        }
        if(dados.id_cultura_anterior() != null){
            this.id_cultura_anterior= dados.id_cultura_anterior();
        }
        if(dados.id_cultura() != null){
            this.id_cultura = dados.id_cultura();
        }

    }

    public void inativar() {
		this.ativo = false;

	}
	
	public void reativar() {
		this.ativo = true;

	}

}
