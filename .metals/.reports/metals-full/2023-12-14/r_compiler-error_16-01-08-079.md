file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/InsumosController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
offset: 2036
uri: file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/InsumosController.java
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

import com.api_planejamento.demo.Insumos.DadosAtualizaInsumo;
import com.api_planejamento.demo.Insumos.DadosCadastroInsumo;
import com.api_planejamento.demo.Insumos.DadosListagemInsumo;
import com.api_planejamento.demo.Insumos.DadosNomeInsumo;
import com.api_planejamento.demo.Insumos.Insumo;
import com.api_planejamento.demo.Insumos.InsumosRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/insumos")
public class InsumosController{

    @Autowired
    private InsumosRepository rep;
    
    @PostMapping
    public ResponseEntity<DadosListagemInsumo> cadastrar(@RequestBody @Valid DadosCadastroInsumo dados, UriComponentsBuilder uriBuilder){
        var insumo = new Insumo(dados);
        rep.save(insumo);

        var uri = uriBuilder.path("/insumos/{id}").buildAndExpand(insumo.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemInsumo(insumo));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemInsumo>> listar(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosListagemInsumo::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
	public ResponseEntity<DadosListagemInsumo> @@GetbyId(@PathVariable  Long id) {
		var insumo = rep.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemInsumo(insumo));
	}

	@GetMapping("/Nome")
    public ResponseEntity<List<DadosNomeInsumo>> listarNome(){
        var lista = rep.findAllByAtivoTrue().stream().map(DadosNomeInsumo::new).toList();
		
		return ResponseEntity.ok(lista);
    }


    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemInsumo>  atualizar(@RequestBody @Valid DadosAtualizaInsumo dados){
        var insumo = rep.getReferenceById(dados.id());
        insumo.atualizarInfos(dados);

        return ResponseEntity.ok(new DadosListagemInsumo(insumo));
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
		var insumo = rep.getReferenceById(id);
		insumo.inativar();

        return ResponseEntity.noContent().build();
	}

    @PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar_logico(@PathVariable Long id) {
		var insumo = rep.getReferenceById(id);
		insumo.reativar();

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
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:34)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:342)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator