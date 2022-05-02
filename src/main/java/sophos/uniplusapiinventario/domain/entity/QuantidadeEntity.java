package sophos.uniplusapiinventario.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "saldoestoque")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantidadeEntity {
    @Id
    private Integer id;

    @Column( name = "quantidade")
    private Double quantidade;

    @Column(name = "nomeproduto")
    private String nome;

}
