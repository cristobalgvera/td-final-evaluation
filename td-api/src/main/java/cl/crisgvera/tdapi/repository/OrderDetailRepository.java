package cl.crisgvera.tdapi.repository;

import cl.crisgvera.tdapi.model.OrderDetail;
import cl.crisgvera.tdapi.model.relational.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
