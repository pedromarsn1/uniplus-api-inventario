package sophos.uniplusapiinventario.requests.davitem;

import lombok.Data;

@Data
public class DavItemPutRequestBody {
    private Integer id;
    private Character itemStatus;
    private Long codProduto;
    private Integer quantidade;
}
