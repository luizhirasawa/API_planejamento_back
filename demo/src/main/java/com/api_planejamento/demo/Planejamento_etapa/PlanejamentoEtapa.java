package com.api_planejamento.demo.Planejamento_etapa;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PE")
@Table(name = "planejamento_etapa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanejamentoEtapa {
    
    public PlanejamentoEtapa(DadosCadastroPE dados){
        this.nome_etapa = dados.nome_etapa();
        this.codigo = dados.codigo();
        this.numero_dias = dados.numero_dias();
        this.estado = dados.estado();
        this.id_planejamento = dados.id_planejamneto();
        this.ativo = true;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String codigo;
    private String nome_etapa;
    private int numero_dias;
    @Enumerated
    private Status_Etapa estado;
    private Long id_planejamento;
    private boolean ativo;

    public void atualizarInfos(@Valid DadosAtualizaPE dados) {
        if(dados.codigo() != null){
            this.codigo = dados.codigo();
        }
        if(dados.nome_etapa() != null){
            this.nome_etapa = dados.nome_etapa();
        }
        if(dados.numero_dias() != Integer.MIN_VALUE){
            this.numero_dias = dados.numero_dias();
        }
        if(dados.estado() != null){
            this.estado = dados.estado();
        }
        if(dados.id_planejamneto() != null){
            this.id_planejamento = dados.id_planejamneto();
        }
    }

    public void inativar() {
		this.ativo = false;

	}
	
	public void reativar() {
		this.ativo = true;

	}
}
