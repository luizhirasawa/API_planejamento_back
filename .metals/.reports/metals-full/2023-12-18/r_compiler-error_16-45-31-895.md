file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/PEIController.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
uri: file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Controllers/PEIController.java
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

    @GetMapping("/consulta/{id}")
    public ResponseEntity<List<Object[]>> querry(@PathVariable  Long id) {
        List<Object[]> resultadosConsulta = rep.consultarDadosInsumosPlanejamento(id);

        return ResponseEntity.ok(resultadosConsulta);
    }

    @GetMapping("/custo/{id}")
    public ResponseEntity<List<Object[]>> custo(@PathVariable  Long id) {
        List<Object[]> resultadosConsulta = rep.consultarDadosCustoInsumo(id);
        
        return ResponseEntity.ok(resultadosConsulta);
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