package cl.crisgvera.tdapi.repository;

import cl.crisgvera.tdapi.model.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, String> {
}
