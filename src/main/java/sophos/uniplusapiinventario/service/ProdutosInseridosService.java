package sophos.uniplusapiinventario.service;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sophos.uniplusapiinventario.domain.entity.ProdutosInseridosEntity;
import sophos.uniplusapiinventario.repository.ProdutosInseridosRepository;
import sophos.uniplusapiinventario.requests.produtos_inseridos.ProdutosInseridosPostRequestBody;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProdutosInseridosService {
    private final ProdutosInseridosRepository produtosInseridosRepository;

    public List<ProdutosInseridosEntity> listAll() {
        return produtosInseridosRepository.findAll();
    }

    @NotNull
    public void deleteAll(){
        produtosInseridosRepository.deleteAll();
    }

    public ProdutosInseridosEntity findbyidOrThrowBadRequestException(int id) {
        return produtosInseridosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));

    }

    public ProdutosInseridosEntity save(ProdutosInseridosPostRequestBody produtosInseridosPostRequestBody) {
        //produto.setId(ThreadLocalRandom.current().nextInt(3,1000000)); //se eu quiser colocar um id aleatório

        return produtosInseridosRepository.save(ProdutosInseridosEntity.builder()
                .id(produtosInseridosPostRequestBody.getId())
                .idProd(produtosInseridosPostRequestBody.getId())
                .codProduto(produtosInseridosPostRequestBody.getCodProduto())
                .nome(produtosInseridosPostRequestBody.getNome())
                .unidade(produtosInseridosPostRequestBody.getUnidade())
                .qtdEstocada(produtosInseridosPostRequestBody.getQtdEstocada())
                .qtdReservada(produtosInseridosPostRequestBody.getQtdReservada())
                .build());

    }

    public void delete(int id) {
        produtosInseridosRepository.delete(findbyidOrThrowBadRequestException(id));
    }


}
