file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/PEController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
uri: file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/PEController.java
text:
```scala
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

import com.api_planejamento.demo.Planejamento_etapa.DadosAtualizaPE;
import com.api_planejamento.demo.Planejamento_etapa.DadosCadastroPE;
import com.api_planejamento.demo.Planejamento_etapa.DadosListagemPE;
import com.api_planejamento.demo.Planejamento_etapa.DadosNomePE;
import com.api_planejamento.demo.Planejamento_etapa.PERepository;
import com.api_planejamento.demo.Planejamento_etapa.PlanejamentoEtapa;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/PlanejamentoEtapa")
public class PEController  {

    @Autowired
    private PERepository rep;
    
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPE dados){
        System.out.println(dados);
        var PE = new PlanejamentoEtapa(dados);
        rep.save(PE);
    }
    
    @GetMapping
    public ResponseEntity<List<DadosListagemPE>> listar(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosListagemPE::new).toList();
		
		return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
	public ResponseEntity<DadosListagemPE> GetbyId(@PathVariable  Long id) {
		var PE = rep.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemPE(PE));
	}

	@GetMapping("/Nome")
    public ResponseEntity<List<DadosNomePE>> listarNome(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosNomePE::new).toList();
		
		return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaPE dados){
        var PE = rep.getReferenceById(dados.id());
        PE.atualizarInfos(dados);
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
		var PE = rep.getReferenceById(id);
		PE.inativar();
		
		return ResponseEntity.noContent().build();
	}

    @PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar_logico(@PathVariable Long id) {
		var PE = rep.getReferenceById(id);
		PE.reativar();
		
		return ResponseEntity.noContent().build();
	}

}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.PcCollector.<init>(PcCollector.scala:45)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:99)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator