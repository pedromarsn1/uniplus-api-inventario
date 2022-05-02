package sophos.uniplusapiinventario.domain.entity;

import jdk.jshell.Snippet;
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
@Table(name = "unidademedidade")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UnidadeEntity {
    @Id
    private Integer id;

    @Column(name = "codigo")
    private String nome;


}
