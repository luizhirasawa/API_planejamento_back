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

import com.api_planejamento.demo.InsumoCultura.DadosAtualizaIC;
import com.api_planejamento.demo.InsumoCultura.DadosCadastroIC;
import com.api_planejamento.demo.InsumoCultura.DadosListagemIC;
import com.api_planejamento.demo.InsumoCultura.ICRepository;
import com.api_planejamento.demo.InsumoCultura.InsumoCultura;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/InsumoCultura")
public class ICController  {

    @Autowired
    private ICRepository rep;
    
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroIC dados){
        var IC = new InsumoCultura(dados);
        rep.save(IC);
    }
    
    @GetMapping
    public ResponseEntity<List<DadosListagemIC>> listar(){
        var lista = rep.findAll().stream().map(DadosListagemIC::new).toList();
		
		return ResponseEntity.ok(lista);
    }
    /* 
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
    */
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemIC> GetbyId(@PathVariable  Long id){
		var IC = rep.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosListagemIC(IC));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaIC dados){
        var IC = rep.getReferenceById(dados.id());
        IC.atualizarInfos(dados);
    }

    @DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable  Long id) {
		rep.deleteById(id);
		
		return ResponseEntity.noContent().build();
    }

}
