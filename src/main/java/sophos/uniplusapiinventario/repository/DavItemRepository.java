package sophos.uniplusapiinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sophos.uniplusapiinventario.domain.entity.DavItemEntity;

@Repository
public interface DavItemRepository extends JpaRepository<DavItemEntity, Integer> {
}
