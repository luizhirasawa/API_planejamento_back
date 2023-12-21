file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/PlantioController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
uri: file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/PlantioController.java
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
import org.springframework.web.util.UriComponentsBuilder;

import com.api_planejamento.demo.Plantio.DadosAtualizaPlantio;
import com.api_planejamento.demo.Plantio.DadosCadastroPlantio;
import com.api_planejamento.demo.Plantio.DadosListagemPlantio;
import com.api_planejamento.demo.Plantio.PlantioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.api_planejamento.demo.Plantio.Plantio;

@RestController
@RequestMapping("/plantio")
public class PlantioController {
    
    @Autowired
    private PlantioRepository rep;

    @PostMapping
    public ResponseEntity<DadosListagemPlantio> cadastrar(@RequestBody DadosCadastroPlantio dados, UriComponentsBuilder uriBuilder){
        var plantio = new Plantio(dados);
        rep.save(plantio);
		
		var uri = uriBuilder.path("/plantio/{id}").buildAndExpand(plantio.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosListagemPlantio(plantio));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPlantio>> listar(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosListagemPlantio::new).toList();
		
		return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
	public ResponseEntity<DadosListagemPlantio> GetbyId(@PathVariable  Long id) {
		var plantio = rep.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemPlantio(plantio));
	}

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemPlantio>  atualizar(@RequestBody @Valid DadosAtualizaPlantio dados){
        var plantio = rep.getReferenceById(dados.id());
        plantio.atualizarInfos(dados);
        
		return ResponseEntity.ok(new DadosListagemPlantio(plantio));
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
		var plantio = rep.getReferenceById(id);
		plantio.inativar();
		
		return ResponseEntity.noContent().build();
	}

    @PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar_logico(@PathVariable Long id) {
		var plantio = rep.getReferenceById(id);
		plantio.reativar();
		
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