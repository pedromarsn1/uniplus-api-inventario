package sophos.uniplusapiinventario.requests.gravar_produtos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class GravarProdutosREPostBody {
    private Integer id;
    private Integer idProduto;
    private Integer qtdEstocada;
}
