package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sophos.uniplusapiinventario.domain.entity.ProdutosInseridosEntity;

public interface ProdutosInseridosRepository extends JpaRepository<ProdutosInseridosEntity, Integer> {
}
