package sophos.uniplusapiinventario.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sophos.uniplusapiinventario.domain.entity.gravar_produtos.GravarProdutosReservadosEstocadosEntity;
import sophos.uniplusapiinventario.repository.GravarProdutosReservadosEstocadosRepository;
import sophos.uniplusapiinventario.requests.gravar_produtos.GravarProdutosREPostBody;
import sophos.uniplusapiinventario.requests.gravar_produtos.GravarProdutosREPutBody;
import sophos.uniplusapiinventario.service.GravarProdutosREService;
import sophos.uniplusapiinventario.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos-gravados")
@Log4j2
@RequiredArgsConstructor
public class GravarProdutosREController {

    @Autowired
    private final DateUtil dateUtil;
    private final GravarProdutosReservadosEstocadosRepository gravarRERepository;
    private final GravarProdutosREService gravarProdutosREService;

    @GetMapping
    public ResponseEntity<List<GravarProdutosReservadosEstocadosEntity>> list(){
        log.info(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(gravarProdutosREService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GravarProdutosReservadosEstocadosEntity> save(@RequestBody GravarProdutosREPostBody gravarProdutosREPostBody){
        return new ResponseEntity<>(gravarProdutosREService.save(gravarProdutosREPostBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id){
        gravarProdutosREService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<GravarProdutosReservadosEstocadosEntity> Put(@PathVariable (value = "id") int id, @RequestBody GravarProdutosREPutBody gravarProdutosREPutBody){
        Optional<GravarProdutosReservadosEstocadosEntity> antigoProduto = gravarRERepository.findById(id);
        if (antigoProduto.isPresent()){
            GravarProdutosReservadosEstocadosEntity produto = antigoProduto.get();
            produto.setId(gravarProdutosREPutBody.getId());
            produto.setIdProduto(gravarProdutosREPutBody.getIdProduto());
            produto.setQtdEstocada(gravarProdutosREPutBody.getQtdEstocada());
            produto.setQtdReservada(gravarProdutosREPutBody.getQtdReservada());
            gravarRERepository.save(produto);
            return new ResponseEntity<>(produto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}