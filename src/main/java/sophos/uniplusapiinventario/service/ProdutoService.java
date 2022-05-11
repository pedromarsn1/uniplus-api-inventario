package sophos.uniplusapiinventario.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sophos.uniplusapiinventario.domain.entity.ProdutoEntity;
import sophos.uniplusapiinventario.repository.ProdutoRepository;
import sophos.uniplusapiinventario.requests.produto.ProdutoPostRequestBody;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProdutoService { //responsável pela regra de negócios
    private final ProdutoRepository produtoRepository;

    public List<ProdutoEntity> listAll() {
        return produtoRepository.findAll();
    }

    public ProdutoEntity findbyidOrThrowBadRequestException(int id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));

    }

    public ProdutoEntity save(ProdutoPostRequestBody produtoPostRequestBody) {
        //produto.setId(ThreadLocalRandom.current().nextInt(3,1000000)); //se eu quiser colocar um id aleatório

        return produtoRepository.save(ProdutoEntity.builder()
                .id(produtoPostRequestBody.getId())
                .nome(produtoPostRequestBody.getNome())
                .unidade(produtoPostRequestBody.getUnidade())
                .codProduto(produtoPostRequestBody.getCodProduto())
                .quantidade(produtoPostRequestBody.getQuantidade())
                .build());

    }

    public void delete(int id) {
        produtoRepository.delete(findbyidOrThrowBadRequestException(id));
    }

}