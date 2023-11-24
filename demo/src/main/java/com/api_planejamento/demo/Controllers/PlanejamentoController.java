package com.api_planejamento.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api_planejamento.demo.Planejamento.DadosAtualizaPlanejamento;
import com.api_planejamento.demo.Planejamento.DadosCadastroPlanejamento;
import com.api_planejamento.demo.Planejamento.DadosListagemPlanejamento;
import com.api_planejamento.demo.Planejamento.DadosNomePlanejamento;
import com.api_planejamento.demo.Planejamento.Planejamento;
import com.api_planejamento.demo.Planejamento.PlanejamentoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/planejamento")
public class PlanejamentoController {
    
    @Autowired
    private PlanejamentoRepository rep;

    @PostMapping
    public ResponseEntity<DadosListagemPlanejamento> cadastrar(@RequestBody DadosCadastroPlanejamento dados, UriComponentsBuilder uriBuilder){
        var planejamento = new Planejamento(dados);
        rep.save(planejamento);
		
		var uri = uriBuilder.path("/planejamento/{id}").buildAndExpand(planejamento.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosListagemPlanejamento(planejamento));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPlanejamento>> listar(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosListagemPlanejamento::new).toList();

        return ResponseEntity.ok(lista);
    }

	@GetMapping("/Nome")
    public ResponseEntity<List<DadosNomePlanejamento>> listarNome(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosNomePlanejamento::new).toList();
		
		return ResponseEntity.ok(lista);
    }
	
    @GetMapping("/{id}")
	public ResponseEntity<DadosListagemPlanejamento> GetbyId(@PathVariable  Long id) {
		var planejamento = rep.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemPlanejamento(planejamento));
	}

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemPlanejamento> atualizar(@RequestBody @Valid DadosAtualizaPlanejamento dados){
        var planejamento = rep.getReferenceById(dados.id());
        planejamento.atualizarInfos(dados);
		
		return ResponseEntity.ok(new DadosListagemPlanejamento(planejamento));
    }

    @PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable  Long id) {
		rep.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

    @DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> excluir_logico(@PathVariable Long id) {
		var planejamento = rep.getReferenceById(id);
		planejamento.inativar();
        
		return ResponseEntity.noContent().build();
	}

    @DeleteMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar_logico(@PathVariable Long id) {
		var planejamento = rep.getReferenceById(id);
		planejamento.reativar();
		
		return ResponseEntity.noContent().build();
	}
}
