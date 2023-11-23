package com.api_planejamento.demo.Cultura;

import java.math.BigDecimal;

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

@Entity(name = "Cultura")
@Table(name = "cultura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Cultura {
    
    public Cultura(DadosCadastroCultura dados){
        this.nome = dados.nome();
        this.preco_venda = dados.preco_venda();
        this.embalagem_venda = dados.embalagem_venda();
        this.ativo = true;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal preco_venda;
    private String embalagem_venda;
    private boolean ativo;

    public void atualizarInfos(@Valid DadosAtualizaCultura dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.preco_venda() != null){
            this.preco_venda = dados.preco_venda();
        }
        if(dados.embalagem_venda() != null){
            this.embalagem_venda = dados.embalagem_venda();
        }
    }

    public void inativar() {
		this.ativo = false;

	}
	
	public void reativar() {
		this.ativo = true;

	}

}
