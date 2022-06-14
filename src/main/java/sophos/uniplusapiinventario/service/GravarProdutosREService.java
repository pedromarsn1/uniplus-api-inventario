package sophos.uniplusapiinventario.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sophos.uniplusapiinventario.domain.entity.GravarProdutosReservadosEstocadosEntity;
import sophos.uniplusapiinventario.repository.GravarProdutosReservadosEstocadosRepository;
import sophos.uniplusapiinventario.requests.gravar_produtos.GravarProdutosREPostBody;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GravarProdutosREService {
    private final GravarProdutosReservadosEstocadosRepository gravarRERepository;

    public List<GravarProdutosReservadosEstocadosEntity> listAll(){
        return gravarRERepository.findAll();
    }

    public GravarProdutosReservadosEstocadosEntity findByIdOrThrowBadRequestException(int id){
        return gravarRERepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Produto não Encontrado"));

    }

    public GravarProdutosReservadosEstocadosEntity save(GravarProdutosREPostBody gravarProdutosREPostBody){
        return gravarRERepository.save(GravarProdutosReservadosEstocadosEntity.builder()
                .id(gravarProdutosREPostBody.getId())
                .idProd(gravarProdutosREPostBody.getIdProduto())
                .qtdEstocada(gravarProdutosREPostBody.getQtdEstocada()).build());
    }

    public void delete(int id){ gravarRERepository.delete(findByIdOrThrowBadRequestException(id));}
}
