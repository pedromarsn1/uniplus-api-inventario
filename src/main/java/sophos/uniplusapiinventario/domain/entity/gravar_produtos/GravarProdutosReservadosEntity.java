package sophos.uniplusapiinventario.domain.entity.gravar_produtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "movimentoestoque")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GravarProdutosReservadosEntity {
    @Id
    private Integer id;

    @Column(name = "idproduto")
    private Integer idProdouto;

    @Column(name = "quantidadentrada")
    private Integer qtdEstocada;

    @Column(name = "quantidadesaida")
    private Integer qtdreservada;
}
