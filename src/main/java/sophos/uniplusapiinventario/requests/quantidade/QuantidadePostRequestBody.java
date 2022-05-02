package sophos.uniplusapiinventario.requests.quantidade;

import lombok.Data;

@Data
public class QuantidadePostRequestBody {
    private Integer idQuantidade;
    private String nomeQuantidade;
    private Double quantidade;
}