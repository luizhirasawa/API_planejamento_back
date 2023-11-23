package com.api_planejamento.demo.Plantio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Plantio")
@Table(name ="plantio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plantio {
    
    public Plantio(DadosCadastroPlantio dados){
        this.nome = dados.nome();
        this.id_cultura_anterior = dados.id_cultura_anterior();
        this.id_planejamento = dados.id_planejamento();
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long id_cultura_anterior;
    private Long id_planejamento;
    private boolean ativo;

    public void atualizarInfos(@Valid DadosAtualizaPlantio dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.id_cultura_anterior() != null){
        this.id_cultura_anterior = dados.id_cultura_anterior();
        }
        if(dados.id_planejamento() != null){
        this.id_planejamento = dados.id_planejamento();
        }
    }

    public void inativar() {
		this.ativo = false;

	}
	
	public void reativar() {
		this.ativo = true;

	}

}
