file:///C:/Users/kirit/Documents/do/API_planejamento/demo/src/main/java/com/api_planejamento/demo/Scala/ScalaComponent.scala
### java.lang.ArrayIndexOutOfBoundsException: Index 167 out of bounds for length 119

occurred in the presentation compiler.

action parameters:
uri: file:///C:/Users/kirit/Documents/do/API_planejamento/demo/src/main/java/com/api_planejamento/demo/Scala/ScalaComponent.scala
text:
```scala
package com.api_planejamento.demo.Scala;



class ScalaComponent {

    def sayHello(): String = "Hello from Scala!"
}
```



#### Error stacktrace:

```
scala.meta.internal.pc.PcCollector.adjust(PcCollector.scala:81)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.collect(PcSemanticTokensProvider.scala:62)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.collect(PcSemanticTokensProvider.scala:18)
	scala.meta.internal.pc.PcCollector.scala$meta$internal$pc$PcCollector$$collect$1(PcCollector.scala:292)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:325)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:288)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$19(PcCollector.scala:469)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:469)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:288)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:328)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:288)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$5(PcCollector.scala:363)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:363)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:288)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$3(PcCollector.scala:342)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:342)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:288)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$3(PcCollector.scala:342)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:342)
	scala.meta.internal.pc.PcCollector.traverseSought(PcCollector.scala:472)
	scala.meta.internal.pc.PcCollector.resultAllOccurences(PcCollector.scala:276)
	scala.meta.internal.pc.PcCollector.result(PcCollector.scala:208)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:71)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticTokens$1(ScalaPresentationCompiler.scala:157)
```
#### Short summary: 

java.lang.ArrayIndexOutOfBoundsException: Index 167 out of bounds for length 119