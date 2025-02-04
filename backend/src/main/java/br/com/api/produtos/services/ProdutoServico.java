package br.com.api.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.models.ProdutoModelo;
import br.com.api.produtos.models.RespostaModelo;
import br.com.api.produtos.repositories.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    public Iterable<ProdutoModelo> listarTodos() {
        return pr.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao) {
        
        if(pm.getNome().isEmpty()) {
            rm.setMensagem("Nome do produto é obrigatório.");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getMarca().isEmpty()) {
            rm.setMensagem(("Marca do produto é obrigatório."));
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }
            
        }
    }

    public ResponseEntity<RespostaModelo> remover (long id) {

        pr.deleteById(id);
        rm.setMensagem("Produto removido com sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

    }           
    
}
