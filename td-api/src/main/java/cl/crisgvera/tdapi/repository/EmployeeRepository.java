package cl.crisgvera.tdapi.repository;

import cl.crisgvera.tdapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Collection<Employee> findEmployeesByJobTitleContains(String jobTitle);
}
