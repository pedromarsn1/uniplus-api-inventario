package sophos.uniplusapiinventario.requests.davitem;

import lombok.Data;

@Data
public class DavItemPostRequestBody {
    private Integer id;
    private Character itemStatus;
    private Long codProduto;
    private Integer quantidade;
}
