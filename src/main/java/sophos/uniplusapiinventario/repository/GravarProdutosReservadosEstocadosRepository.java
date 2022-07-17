package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sophos.uniplusapiinventario.domain.entity.GravarProdutosReservadosEstocadosEntity;

import java.util.Optional;

@Repository
public interface GravarProdutosReservadosEstocadosRepository extends JpaRepository<GravarProdutosReservadosEstocadosEntity,Integer> {
    Optional<GravarProdutosReservadosEstocadosEntity> findByIdProd(Integer idProd);
}
