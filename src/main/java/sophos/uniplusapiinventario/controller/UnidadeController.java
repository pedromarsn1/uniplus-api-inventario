package sophos.uniplusapiinventario.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sophos.uniplusapiinventario.domain.entity.UnidadeEntity;
import sophos.uniplusapiinventario.repository.UnidadeRepository;
import sophos.uniplusapiinventario.requests.unidade.UnidadePostRequestBody;
import sophos.uniplusapiinventario.requests.unidade.UnidadePutRequestBody;
import sophos.uniplusapiinventario.service.UnidadeService;
import sophos.uniplusapiinventario.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("unidades")
@Log4j2
@RequiredArgsConstructor
public class UnidadeController {
    @Autowired
    private final DateUtil dateUtil;
    private final UnidadeRepository unidadeRepository;
    private final UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<List<UnidadeEntity>> list(){
        log.info(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(unidadeService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"/id"})
    public ResponseEntity<UnidadeEntity> findById(@PathVariable int id){
        return new ResponseEntity<>(unidadeService.findbyidOrThowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UnidadeEntity> save(@RequestBody UnidadePostRequestBody unidadePostRequestBody) {
        return new ResponseEntity<>(unidadeService.saveUniGrupo(unidadePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        unidadeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UnidadeEntity> Put(@PathVariable(value = "id") int id, @RequestBody UnidadePutRequestBody unidadePutRequestBody) {
        Optional<UnidadeEntity> antigaUnidade = unidadeRepository.findById(id);

        if(antigaUnidade.isPresent()){
            UnidadeEntity unidade = antigaUnidade.get();
            unidade.setNome(unidadePutRequestBody.getNomeUnidade());

            unidadeRepository.save(unidade);
            return new ResponseEntity<UnidadeEntity>(unidade,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
