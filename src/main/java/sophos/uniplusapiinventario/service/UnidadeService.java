package sophos.uniplusapiinventario.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sophos.uniplusapiinventario.domain.entity.UnidadeEntity;
import sophos.uniplusapiinventario.repository.UnidadeRepository;
import sophos.uniplusapiinventario.requests.unidade.UnidadePostRequestBody;
import sophos.uniplusapiinventario.requests.unidade.UnidadePutRequestBody;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UnidadeService {
    private final UnidadeRepository unidadeRepository;

    public List<UnidadeEntity> listAll() {
        return unidadeRepository.findAll();
    }

    public UnidadeEntity findbyidOrThowBadRequestException(int id) {
        return unidadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unidade e grupo não encontrados"));
    }

    public UnidadeEntity saveUniGrupo(UnidadePostRequestBody unidadePostRequestBody){
        return unidadeRepository.save(UnidadeEntity.builder()
                .id(unidadePostRequestBody.getIdUnidade())
                .nome(unidadePostRequestBody.getNomeUnidade())
                .build());

    }

    public void delete(int id){
        unidadeRepository.delete(findbyidOrThowBadRequestException(id));
    }

    public void replaceUniGrupo(UnidadePutRequestBody unidadePutRequestBody){
        UnidadeEntity unidade = UnidadeEntity.builder()
                .id(unidadePutRequestBody.getIdUnidade())
                .nome(unidadePutRequestBody.getNomeUnidade())
                .build();

        unidadeRepository.save(unidade);
    }
}
