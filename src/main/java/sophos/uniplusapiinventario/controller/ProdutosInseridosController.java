package sophos.uniplusapiinventario.controller;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sophos.uniplusapiinventario.domain.entity.ProdutosInseridosEntity;
import sophos.uniplusapiinventario.repository.ProdutosInseridosRepository;
import sophos.uniplusapiinventario.requests.produtos_inseridos.ProdutosInseridosPostRequestBody;
import sophos.uniplusapiinventario.requests.produtos_inseridos.ProdutosInseridosPutRequestBody;
import sophos.uniplusapiinventario.service.ProdutosInseridosService;
import sophos.uniplusapiinventario.util.DateUtil;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController // faz com que o retorno dos dados sejam apenas strings
@RequestMapping(value = "produtos-inseridos", produces = APPLICATION_JSON_UTF8_VALUE) // rota no nível da classe
@Log4j2
@RequiredArgsConstructor
public class ProdutosInseridosController {
    @Autowired
    private final DateUtil dateUtil;
    @Autowired
    private final ProdutosInseridosRepository produtosInseridosRepository;
    @Autowired
    private final ProdutosInseridosService produtosInseridosService;

   @NotNull
    private String encodeValue(String value) {
           try {
               return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
           } catch (UnsupportedEncodingException ex) {
               throw new RuntimeException(ex.getCause());
           }
   }


    @GetMapping
    public ResponseEntity<List<ProdutosInseridosEntity>> list() {
        log.info(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(produtosInseridosService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutosInseridosEntity> findById(@PathVariable int id) {
        return new ResponseEntity<>(produtosInseridosService.findbyidOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutosInseridosEntity> save(@RequestBody ProdutosInseridosPostRequestBody produtosInseridosPostRequestBody) {
        return new ResponseEntity<>(produtosInseridosService.save(produtosInseridosPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete-all/{id}")
    public ResponseEntity<Void> deleteAll(){
       produtosInseridosService.deleteAll();
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    };


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        produtosInseridosService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProdutosInseridosEntity> Put(@PathVariable(value = "id") int id, @RequestBody ProdutosInseridosPutRequestBody produtosInseridosPutRequestBody) {
        Optional<ProdutosInseridosEntity> antigoProduto = produtosInseridosRepository.findById(id);
        if (antigoProduto.isPresent()) {
            ProdutosInseridosEntity produto = antigoProduto.get();
            produto.setNome(produtosInseridosPutRequestBody.getNome());
            produto.setCodProduto(produtosInseridosPutRequestBody.getCodProduto());
            produto.setUnidade(produtosInseridosPutRequestBody.getUnidade());
            produto.setQtdEstocada(produtosInseridosPutRequestBody.getQtdEstocada());
            produto.setQtdReservada(produtosInseridosPutRequestBody.getQtdReservada());
            produtosInseridosRepository.save(produto);
            return new ResponseEntity<ProdutosInseridosEntity>(produto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
