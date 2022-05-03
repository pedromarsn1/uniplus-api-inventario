package sophos.uniplusapiinventario.requests.quantidade;

import lombok.Data;

@Data
public class QuantidadePutRequestBody {
    private Integer idQuantidade;
    private String nomeQuantidade;
    private Double quantidade;
    private Integer codProd;
}
