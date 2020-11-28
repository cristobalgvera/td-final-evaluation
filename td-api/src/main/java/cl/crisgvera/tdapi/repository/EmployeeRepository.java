package cl.crisgvera.tdapi.repository;

import cl.crisgvera.tdapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Collection<Employee> findEmployeesByJobTitleContains(String jobTitle);

    Collection<Employee> findEmployeesByOffice_CityAndParentEmployee_Id(String office_city, Long parentEmployee_id);

    Collection<Employee> findEmployeesByParentEmployee_Id(Long parentEmployee_id);

    Collection<Employee> findEmployeesByOffice_City(String office_city);

    default Collection<Employee> findAllByOfficeCityAndParentId(String office_city, Long parentEmployee_id) {
        return findEmployeesByOffice_CityAndParentEmployee_Id(office_city, parentEmployee_id);
    }
}
