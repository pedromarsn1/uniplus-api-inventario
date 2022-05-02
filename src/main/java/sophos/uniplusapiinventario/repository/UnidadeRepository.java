package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sophos.uniplusapiinventario.domain.entity.UnidadeEntity;

@Repository
public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Integer> {
}
