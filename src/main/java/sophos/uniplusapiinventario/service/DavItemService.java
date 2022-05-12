package sophos.uniplusapiinventario.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sophos.uniplusapiinventario.domain.entity.DavItemEntity;
import sophos.uniplusapiinventario.repository.DavItemRepository;
import sophos.uniplusapiinventario.requests.davitem.DavItemPostRequestBody;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DavItemService {
    private final DavItemRepository davItemRepository;

    public List<DavItemEntity> listAll(){
        return davItemRepository.findAll();
    }

    public DavItemEntity findByIdOrThrowBadRequestException(int id){
        return davItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));
    }

    public DavItemEntity save(DavItemPostRequestBody davItemPostRequestBody){
        return davItemRepository.save(DavItemEntity.builder()
                        .id(davItemPostRequestBody.getId())
                        .codProduto(davItemPostRequestBody.getCodProduto())
                        .quantidade(davItemPostRequestBody.getQuantidade())
                        .itemStatus(davItemPostRequestBody.getItemStatus()).build());
    }

    public void delete(int id){davItemRepository.delete(findByIdOrThrowBadRequestException(id));}
}
