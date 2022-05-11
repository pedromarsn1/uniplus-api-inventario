package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sophos.uniplusapiinventario.domain.entity.ProdutosInseridosEntity;

@Repository
public interface ProdutosInseridosRepository extends JpaRepository<ProdutosInseridosEntity, Integer> {
}
