package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sophos.uniplusapiinventario.domain.entity.gravar_produtos.GravarProdutosReservadosEstocadosEntity;

@Repository
public interface GravarProdutosReservadosEstocadosRepository extends JpaRepository<GravarProdutosReservadosEstocadosEntity,Integer> {
}
