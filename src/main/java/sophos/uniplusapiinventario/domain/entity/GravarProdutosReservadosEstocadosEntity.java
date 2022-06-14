package sophos.uniplusapiinventario.domain.entity;

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
//Aqui vai estar a quantidade que eu vou atualizar
public class GravarProdutosReservadosEstocadosEntity {
    @Id
    private Integer id;

    @Column(name = "idproduto")
    private Integer idProd;

    @Column(name = "quantidadeentrada")
    private Integer qtdEstocada;
}
