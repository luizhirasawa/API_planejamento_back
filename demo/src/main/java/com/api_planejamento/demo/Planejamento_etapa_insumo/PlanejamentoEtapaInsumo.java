package com.api_planejamento.demo.Planejamento_etapa_insumo;

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

@Entity(name = "PEI")
@Table(name = "planejamento_etapa_insumo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanejamentoEtapaInsumo {
    
    public PlanejamentoEtapaInsumo(DadosCadastroPEI dados){
        this.unidade = dados.unidade();
        this.quantidade_ha = dados.quantidade_ha();
        this.planejamento_etapa_id = dados.planejamento_etapa_id();
        this.id_cultura = dados.id_cultura();
        this.id_insumo = dados.id_insumo();
        this.ativo = true;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Unidade unidade;
    private int quantidade_ha;
    private Long planejamento_etapa_id;
    private Long id_cultura;
    private Long id_insumo;
    private boolean ativo;

    public void atualizarInfos(@Valid DadosAtualizaPEI dados) {
        if(dados.unidade() != null){
            this.unidade = dados.unidade();
        }
        if(dados.quantidade_ha() != Integer.MIN_VALUE){
            this.quantidade_ha = dados.quantidade_ha();
        }
        if(dados.planejamento_etapa_id() != null){
            this.planejamento_etapa_id = dados.planejamento_etapa_id();
        }
        if(dados.id_cultura() != null){
            this.id_cultura = dados.id_cultura();
        }
        if(dados.id_insumo() != null){
            this.id_insumo = dados.id_insumo();
        }
    }

    public void inativar() {
		this.ativo = false;

	}
	
	public void reativar() {
		this.ativo = true;

	}
}
