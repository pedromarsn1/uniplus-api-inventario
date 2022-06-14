package sophos.uniplusapiinventario.requests.produtos_inseridos;

import lombok.Data;
import sophos.uniplusapiinventario.domain.entity.ProdutoEntity;

@Data
public class ProdutosInseridosPutRequestBody {
    private Integer id;
    private Integer idProduto;
    private String nome;
    private long codProduto;
    private String unidade;
    private int qtdEstocada;
    private int qtdReservada;
}
