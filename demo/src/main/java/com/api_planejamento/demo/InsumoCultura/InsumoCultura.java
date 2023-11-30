package com.api_planejamento.demo.InsumoCultura;

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

@Entity(name = "IC")
@Table(name = "insumo_cultura_qtdha")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsumoCultura {
    
    public InsumoCultura(DadosCadastroIC dados){
        this.quantidade_ha = dados.quantidade_ha();
        this.id_cultura = dados.id_cultura();
        this.id_insumo = dados.id_insumo();
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int quantidade_ha;
    private Long id_cultura;
    private Long id_insumo;
    

    public void atualizarInfos(@Valid DadosAtualizaIC dados) {
        if(dados.quantidade_ha() != Integer.MIN_VALUE){
            this.quantidade_ha = dados.quantidade_ha();
        }
        if(dados.id_cultura() != null){
            this.id_cultura = dados.id_cultura();
        }
        if(dados.id_insumo() != null){
            this.id_insumo = dados.id_insumo();
        }
    }
}
