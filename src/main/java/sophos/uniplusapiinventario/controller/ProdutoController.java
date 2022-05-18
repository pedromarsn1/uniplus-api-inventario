package sophos.uniplusapiinventario.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sophos.uniplusapiinventario.domain.entity.ProdutoEntity;
import sophos.uniplusapiinventario.repository.ProdutoRepository;
import sophos.uniplusapiinventario.requests.produto.ProdutoPostRequestBody;
import sophos.uniplusapiinventario.requests.produto.ProdutoPutRequestBody;
import sophos.uniplusapiinventario.service.ProdutoService;
import sophos.uniplusapiinventario.util.DateUtil;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController // faz com que o retorno dos dados sejam apenas strings
@RequestMapping("produtos") // rota no nível da classe
@Log4j2
@RequiredArgsConstructor
public class ProdutoController {
    @Autowired
    private final DateUtil dateUtil;
    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> list() {
        log.info(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(produtoService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoEntity> findById(@PathVariable int id) {
        return new ResponseEntity<>(produtoService.findbyidOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> save(@RequestBody ProdutoPostRequestBody produtoPostRequestBody) {
        return new ResponseEntity<>(produtoService.save(produtoPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProdutoEntity> Put(@PathVariable(value = "id") int id, @RequestBody ProdutoPutRequestBody produtoPutRequestBody) {
        Optional<ProdutoEntity> antigoProduto = produtoRepository.findById(id);
        if (antigoProduto.isPresent()) {
            ProdutoEntity produto = antigoProduto.get();
            produto.setNome(produtoPutRequestBody.getNome());
            produto.setCodProduto(produtoPutRequestBody.getCodProduto());
            produto.setUnidade(produtoPutRequestBody.getUnidade());
            produto.setQuantidade(produtoPutRequestBody.getQuantidade());
            produtoRepository.save(produto);
            return new ResponseEntity<ProdutoEntity>(produto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
