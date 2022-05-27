package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sophos.uniplusapiinventario.domain.entity.ProdutosInseridosEntity;

import java.util.List;

@Repository
public interface ProdutosInseridosRepository extends JpaRepository<ProdutosInseridosEntity, Integer> {

    // void deleteAll(List<ProdutosInseridosEntity> entities);
}
