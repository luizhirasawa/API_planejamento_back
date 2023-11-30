package com.api_planejamento.demo.Planejamento_etapa;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity(name = "PE")
@Table(name = "planejamento_etapa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanejamentoEtapa {
    
    public PlanejamentoEtapa(DadosCadastroPE dados){
        this.nome_etapa = dados.nome_etapa();
        this.numero_dias = dados.numero_dias();
        this.estado = dados.estado();
        this.id_planejamento = dados.id_planejamento();
        this.ativo = true;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome_etapa;
    private int numero_dias;
    @Enumerated(EnumType.STRING)
    private StatusEtapa estado;
    private Long id_planejamento;
    private boolean ativo;

    public void atualizarInfos(@Valid DadosAtualizaPE dados) {
        if(dados.nome_etapa() != null){
            this.nome_etapa = dados.nome_etapa();
        }
        if(dados.numero_dias() != Integer.MIN_VALUE){
            this.numero_dias = dados.numero_dias();
        }
        if(dados.estado() != null){
            this.estado = dados.estado();
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
