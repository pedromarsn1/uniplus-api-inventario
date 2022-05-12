package sophos.uniplusapiinventario.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "davitem")
public class DavItemEntity {
    @Id
    private Integer id;

    @Column(name = "tiporetiradaentregaitem")
    private Character itemStatus;

    @Column(name = "idproduto")
    private Long codProduto;

    @Column (name = "quantidade")
    private Integer quantidade;


}
