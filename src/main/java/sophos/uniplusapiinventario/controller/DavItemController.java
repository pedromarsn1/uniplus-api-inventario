package sophos.uniplusapiinventario.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sophos.uniplusapiinventario.domain.entity.DavItemEntity;
import sophos.uniplusapiinventario.repository.DavItemRepository;
import sophos.uniplusapiinventario.requests.davitem.DavItemPostRequestBody;
import sophos.uniplusapiinventario.requests.davitem.DavItemPutRequestBody;
import sophos.uniplusapiinventario.service.DavItemService;
import sophos.uniplusapiinventario.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("davitem")
@Log4j2
@RequiredArgsConstructor
public class DavItemController {
    @Autowired
    private final DateUtil dateUtil;
    private final DavItemRepository davItemRepository;
    private final DavItemService davItemService;

    @GetMapping
    public ResponseEntity<List<DavItemEntity>> list(){
        log.info(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(davItemService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DavItemEntity> save(@RequestBody DavItemPostRequestBody davItemPostRequestBody){
        return new ResponseEntity<>(davItemService.save(davItemPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id ){
        davItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DavItemEntity> Put(@PathVariable(value = "id") int id, @RequestBody DavItemPutRequestBody davItemPutRequestBody){
        Optional<DavItemEntity> antigoProduto = davItemRepository.findById(id);
        if (antigoProduto.isPresent()){
            DavItemEntity produto = antigoProduto.get();
            produto.setId(davItemPutRequestBody.getId());
            produto.setCodProduto(davItemPutRequestBody.getCodProduto());
            produto.setQuantidade(davItemPutRequestBody.getQuantidade());
            davItemRepository.save(produto);
            return new ResponseEntity<>(produto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
