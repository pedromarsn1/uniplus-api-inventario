package sophos.uniplusapiinventario.requests.produtos_inseridos;

import lombok.Data;
import sophos.uniplusapiinventario.domain.entity.ProdutoEntity;

@Data
public class ProdutosInseridosPostRequestBody {
    private Integer id;
    private ProdutoEntity idProduto;
    private String nome;
    private long codProduto;
    private String unidade;
    private int qtdEstocada;
    private int qtdReservada;
}
