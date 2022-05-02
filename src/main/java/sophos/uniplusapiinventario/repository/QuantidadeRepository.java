package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sophos.uniplusapiinventario.domain.entity.QuantidadeEntity;

@Repository
public interface QuantidadeRepository extends JpaRepository<QuantidadeEntity, Integer> {
}
