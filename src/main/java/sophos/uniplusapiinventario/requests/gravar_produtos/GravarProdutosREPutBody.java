package sophos.uniplusapiinventario.requests.gravar_produtos;

import lombok.Data;

@Data
public class GravarProdutosREPutBody {
    private Integer id;
    private Integer idProduto;
    private Integer qtdEstocada;
    private Integer qtdReservada;
}
