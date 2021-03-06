package cl.crisgvera.tdapi.repository;

import cl.crisgvera.tdapi.model.Payment;
import cl.crisgvera.tdapi.model.relational.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}
