package com.api_planejamento.demo.Insumos;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
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

@Entity(name = "Insumo")
@Table(name ="insumos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insumo {

    public Insumo(DadosCadastroInsumo dados){
        this.nome = dados.nome();
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
        this.principio_ativo = dados.principio_ativo();
        this.grupo = dados.grupo();
        this.subclasse = dados.subclasse();
        this.fabricante = dados.fabricante();
        this.preco = dados.preco();
        this.unidade = dados.unidade();
        this.ativo = true;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String codigo;
    private String descricao;
    private String principio_ativo;
    private String grupo;
    @Enumerated(EnumType.STRING)
    private Classe subclasse;
    @Enumerated(EnumType.STRING)
    private Fabricante fabricante;
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private Unidade unidade;
    private boolean ativo;

    public void atualizarInfos(@Valid DadosAtualizaInsumo dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.codigo() != null){
        this.codigo = dados.codigo();
        }
        if(dados.descricao() != null){
        this.descricao = dados.descricao();
        }
        if(dados.principio_ativo() != null){
        this.principio_ativo = dados.principio_ativo();
        }
        if(dados.grupo() != null){
        this.grupo = dados.grupo();
        }
        if(dados.subclasse() != null){
            this.subclasse = dados.subclasse();
        }
        if(dados.fabricante() != null){
        this.fabricante = dados.fabricante();
        }
        if(dados.preco() != null){
        this.preco = dados.preco();
        }
        if(dados.unidade() != null){
            this.unidade = dados.unidade();
          }
    }

    public void inativar() {
		this.ativo = false;

	}
	
	public void reativar() {
		this.ativo = true;

	}
    
}
