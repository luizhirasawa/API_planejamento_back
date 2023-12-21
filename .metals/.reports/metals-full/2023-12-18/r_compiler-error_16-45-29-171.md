file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Planejamento_etapa_insumo/PEIRepository.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
uri: file:///C:/Users/kirit/Documents/API/API_planejamento_back/demo/src/main/java/com/api_planejamento/demo/Planejamento_etapa_insumo/PEIRepository.java
text:
```scala
package com.api_planejamento.demo.Planejamento_etapa_insumo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PEIRepository extends JpaRepository<PlanejamentoEtapaInsumo, Long>{
    
    List<PlanejamentoEtapaInsumo> findAllByAtivoTrue();

    @Query("SELECT i.nome, i.preco, pei.quantidade_ha, p.area_plantio " +
        "FROM Insumo i " +
        "JOIN PEI pei ON pei.id_insumo = i.id " +
        "JOIN PE pe ON pei.planejamento_etapa_id = pe.id " +
        "JOIN Planejamento p ON pe.id_planejamento = p.id " +
        "JOIN Plantio pl ON p.id = pl.id_planejamento " +
        "WHERE p.id = :idPlantio"
    )List<Object[]> consultarDadosInsumosPlanejamento(
        @Param("idPlantio") Long idPlantio
    );

    @Query("SELECT i, pei, p, pl " +
        "FROM Insumo i " +
        "JOIN PEI pei ON pei.id_insumo = i.id " +
        "JOIN PE pe ON pei.planejamento_etapa_id = pe.id " +
        "JOIN Planejamento p ON pe.id_planejamento = p.id " +
        "JOIN Plantio pl ON p.id = pl.id_planejamento " +
        "WHERE p.id = :idPlantio"
    )List<Object[]> consultarDadosInsumosPreco(
        @Param("idPlantio") Long idPlantio
    );

    @Query(
        "select i.nome, ((i.preco * pei.quantidade_ha)/p.area_plantio) as Custo " + 
        "FROM Insumo i " +
        "JOIN PEI pei ON pei.id_insumo = i.id " +
        "JOIN PE pe ON pei.planejamento_etapa_id = pe.id " +
        "JOIN Planejamento p ON pe.id_planejamento = p.id " +
        "JOIN Plantio pl ON p.id = pl.id_planejamento " +
        "WHERE p.id = :idPlantio"
    )List<Object[]> consultarDadosCustoInsumo(
        @Param("idPlantio") Long idPlantio
    );

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