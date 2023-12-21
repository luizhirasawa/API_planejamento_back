file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/CulturaController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
uri: file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/CulturaController.java
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