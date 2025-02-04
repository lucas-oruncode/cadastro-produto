package br.com.api.produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.models.ProdutoModelo;
import br.com.api.produtos.services.ProdutoServico;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;
    
    @GetMapping("/api/produtos")
    public Iterable<ProdutoModelo> listarTodos() {
        return ps.listarTodos();
    }

    @PostMapping("/api/produtos")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm) {
        return ps.cadastrarAlterar(pm, "cadastrar");
    }   
    
    @PutMapping("/api/produtos")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm) {
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @DeleteMapping("/api/produtos/{id}")
    public ResponseEntity<?> remover(@PathVariable long id) {
        return ps.remover(id);
    }
}
