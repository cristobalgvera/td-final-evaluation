package cl.crisgvera.tdapi.repository;

import cl.crisgvera.tdapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Collection<Customer> findCustomersByNameContains(String nameContains);
}
