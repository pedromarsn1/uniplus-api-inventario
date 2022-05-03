package sophos.uniplusapiinventario.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sophos.uniplusapiinventario.domain.entity.QuantidadeEntity;
import sophos.uniplusapiinventario.repository.QuantidadeRepository;
import sophos.uniplusapiinventario.requests.quantidade.QuantidadePostRequestBody;
import sophos.uniplusapiinventario.requests.quantidade.QuantidadePutRequestBody;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuantidadeService {
    private final QuantidadeRepository quantidadeRepository;

    public List<QuantidadeEntity> listAll() {
        return quantidadeRepository.findAll();
    }

    public QuantidadeEntity findbyidOrThrowBadRequestException(int id) {
        return quantidadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));

    }

    public QuantidadeEntity save(QuantidadePostRequestBody quantidadePostRequestBody) {
        //produto.setId(ThreadLocalRandom.current().nextInt(3,1000000)); //se eu quiser colocar um id aleatório

        return quantidadeRepository.save(QuantidadeEntity.builder()
                .nome(quantidadePostRequestBody.getNomeQuantidade())
                .id(quantidadePostRequestBody.getIdQuantidade())
                .codProd(quantidadePostRequestBody.getCodProd())
                .quantidade(quantidadePostRequestBody.getQuantidade())
                .build());
    }

    public void delete(int id) {
        quantidadeRepository.delete(findbyidOrThrowBadRequestException(id));
    }


    public void replaceGrupo(QuantidadePutRequestBody quantidadePutRequestBody) {
        QuantidadeEntity quantidade = QuantidadeEntity.builder()
                .quantidade(quantidadePutRequestBody.getQuantidade())
                .build();

        quantidadeRepository.save(quantidade);
    }
}
