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

import com.api_planejamento.demo.Cultura.Cultura;
import com.api_planejamento.demo.Cultura.CulturaRepository;
import com.api_planejamento.demo.Cultura.DadosAtualizaCultura;
import com.api_planejamento.demo.Cultura.DadosCadastroCultura;
import com.api_planejamento.demo.Cultura.DadosListagemCultura;
import com.api_planejamento.demo.Cultura.DadosNomeCultura;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cultura")
public class CulturaController {
    
    @Autowired
    private CulturaRepository rep;

    @PostMapping
    public ResponseEntity<DadosListagemCultura>  cadastrar(@RequestBody @Valid DadosCadastroCultura dados, UriComponentsBuilder uriBuilder){
        var cultura = new Cultura(dados);
        rep.save(cultura);
        
        var uri = uriBuilder.path("/cultura/{id}").buildAndExpand(cultura.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemCultura(cultura));
    }



    @GetMapping
    public ResponseEntity<List<DadosListagemCultura>> listar(){
        var lista =  rep.findAllByAtivoTrue().stream().map(DadosListagemCultura::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
	public ResponseEntity<DadosListagemCultura> GetbyId(@PathVariable  Long id) {
		var cultura = rep.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemCultura(cultura));
	}

	@GetMapping("/Nome")
    public ResponseEntity<List<DadosNomeCultura>> listarNome(){
        var lista = rep.findAll().stream().map(DadosNomeCultura::new).toList();
		
		return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemCultura>  atualizar(@RequestBody @Valid DadosAtualizaCultura dados){
        var cultura = rep.getReferenceById(dados.id());
        cultura.atualizarInfos(dados);

        return ResponseEntity.ok(new DadosListagemCultura(cultura));
    }

    @DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable  Long id) {
		rep.deleteById(id);

        return ResponseEntity.noContent().build();
	}

    @DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void>  excluir_logico(@PathVariable Long id) {
		var cultura = rep.getReferenceById(id);
		cultura.inativar();

        return ResponseEntity.noContent().build();
	}

    @PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar_logico(@PathVariable Long id) {
		var cultura = rep.getReferenceById(id);
		cultura.reativar();

        return ResponseEntity.noContent().build();
	}

}
