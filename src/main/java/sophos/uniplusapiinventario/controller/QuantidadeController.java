package sophos.uniplusapiinventario.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sophos.uniplusapiinventario.domain.entity.QuantidadeEntity;
import sophos.uniplusapiinventario.repository.QuantidadeRepository;
import sophos.uniplusapiinventario.requests.quantidade.QuantidadePostRequestBody;
import sophos.uniplusapiinventario.requests.quantidade.QuantidadePutRequestBody;
import sophos.uniplusapiinventario.service.QuantidadeService;
import sophos.uniplusapiinventario.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("quantidades")
@Log4j2
@RequiredArgsConstructor
@Component
public class QuantidadeController {
    @Autowired
    private final DateUtil dateUtil;
    private final QuantidadeRepository quantidadeRepository;
    private final QuantidadeService quantidadeService;

    @GetMapping
    public ResponseEntity<List<QuantidadeEntity>> list(){
        log.info(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(quantidadeService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"/id"})
    public ResponseEntity<QuantidadeEntity> findById(@PathVariable int id){
        return new ResponseEntity<>(quantidadeService.findbyidOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuantidadeEntity> save(@RequestBody QuantidadePostRequestBody quantidadePostRequestBody) {
        return new ResponseEntity<>(quantidadeService.save(quantidadePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        quantidadeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<QuantidadeEntity> Put(@PathVariable(value = "id") int id, @RequestBody QuantidadePutRequestBody quantidadePutRequestBody) {
        Optional<QuantidadeEntity> antigaQuantidade = quantidadeRepository.findById(id);

        if(antigaQuantidade.isPresent()){
            QuantidadeEntity quantidade = antigaQuantidade.get();
            quantidade.setQuantidade(quantidadePutRequestBody.getQuantidade());

            quantidadeRepository.save(quantidade);
            return new ResponseEntity<QuantidadeEntity>(quantidade, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
