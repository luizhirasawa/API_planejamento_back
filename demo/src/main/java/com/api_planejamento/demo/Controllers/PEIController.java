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

import com.api_planejamento.demo.Planejamento_etapa_insumo.DadosAtualizaPEI;
import com.api_planejamento.demo.Planejamento_etapa_insumo.DadosCadastroPEI;
import com.api_planejamento.demo.Planejamento_etapa_insumo.DadosListagemPEI;
import com.api_planejamento.demo.Planejamento_etapa_insumo.PEIRepository;
import com.api_planejamento.demo.Planejamento_etapa_insumo.PlanejamentoEtapaInsumo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/PlanejamentoEtapaInsumo")
public class PEIController  {

    @Autowired
    private PEIRepository rep;
    
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPEI dados){
        var PEI = new PlanejamentoEtapaInsumo(dados);
        rep.save(PEI);
    }
    
    @GetMapping
    public ResponseEntity<List<DadosListagemPEI>> listar(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosListagemPEI::new).toList();
		
		return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemPEI> GetbyId(@PathVariable  Long id){
		var PEI = rep.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemPEI(PEI));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaPEI dados){
        var PEI = rep.getReferenceById(dados.id());
        PEI.atualizarInfos(dados);
    }

    @DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable  Long id) {
		rep.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

    @DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> excluir_logico(@PathVariable Long id) {
		var PEI = rep.getReferenceById(id);
		PEI.inativar();
		
		return ResponseEntity.noContent().build();
	}

    @PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar_logico(@PathVariable Long id) {
		var PEI = rep.getReferenceById(id);
		PEI.reativar();
		
		return ResponseEntity.noContent().build();
	}

}
