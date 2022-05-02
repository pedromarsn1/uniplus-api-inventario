package sophos.uniplusapiinventario.requests.produto;

import lombok.Data;

@Data
public class ProdutoPutRequestBody {
    private Integer id;
    private String nome;
    private String grupo;
    private String unidade;
    private Integer codProduto;
    private Integer quantidade;

}
