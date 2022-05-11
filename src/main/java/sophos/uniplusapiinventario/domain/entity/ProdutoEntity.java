package sophos.uniplusapiinventario.domain.entity;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProdutoEntity {
    @Id
    private Integer id;

    @Column(name = "nomeecf")
    private String nome;

    @Column(name = "codigo")
    private Integer codProduto;

    @Column(name= "unidademedida")
    private String unidade;

    private Integer quantidade;

}
