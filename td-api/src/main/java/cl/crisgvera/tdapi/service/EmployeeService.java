package cl.crisgvera.tdapi.service;

import cl.crisgvera.tdapi.dto.AEmployeeDto;
import cl.crisgvera.tdapi.dto.CEmployeeDto;
import cl.crisgvera.tdapi.model.Employee;
import cl.crisgvera.tdapi.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Collection<Employee> findAllByJobTitle(String jobTitle) {
        log.info("[EmployeeService] findAllByJobTitle | jobTitle = " + jobTitle);
        Collection<Employee> employees = employeeRepository.findEmployeesByJobTitleContains(jobTitle);
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Collection<Employee> findAllByOfficeCityAndParentId(String officeCity, Long parentEmployeeId) {
        log.info("[EmployeeService] findAllByOfficeCityAndParentId");
        if (parentEmployeeId == null && officeCity.equals(""))
            return findAllByJobTitle("Sales Rep");

        if (parentEmployeeId == null)
            return employeeRepository.findEmployeesByOffice_City(officeCity);

        if (officeCity.equals(""))
            return employeeRepository.findEmployeesByParentEmployee_Id(parentEmployeeId);

        return employeeRepository.findAllByOfficeCityAndParentId(officeCity, parentEmployeeId);
    }

    public Collection<AEmployeeDto> getAllEmployeesByJobTitleFilteredByADto(String jobTitle) {
        log.info("[EmployeeService] getAllEmployeesByJobTitle | jobTitle = " + jobTitle);
        Collection<Employee> employees = employeeRepository.findEmployeesByJobTitleContains(jobTitle);

//        employees = employees.stream()
//                .sorted(Comparator.comparing(employee -> employee.getOffice().getCountry()))
//                .sorted(Comparator.comparing(employee -> employee.getOffice().getCity()))
//                .sorted(Comparator.comparing(Employee::getFirstName))
//                .collect(Collectors.toCollection(LinkedHashSet::new));

        return employees.stream()
                .map(employee -> AEmployeeDto.builder()
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .email(employee.getEmail())
                        .officeCity(employee.getOffice().getCity())
                        .officeCountry(employee.getOffice().getCountry())
                        .build())
                .collect(Collectors.toCollection(HashSet::new));
    }

    public Collection<CEmployeeDto> getAllEmployeesByJobTitleFilteredByClientPortfolioLength(String jobTitle) {
        log.info("[EmployeeService] getAllEmployeesByJobTitleFilteredByClientPortfolioLength | jobTitle = " + jobTitle);
        Collection<Employee> employees = employeeRepository.findEmployeesByJobTitleContains(jobTitle);

        return employees.stream()
                .map(employee -> CEmployeeDto.builder()
                        .employeeNumber(employee.getId())
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .clientPortfolioLength(employee.getCustomers().size())
                        .build())
                .sorted((o1, o2) -> (int) Math.max(o1.getClientPortfolioLength(), o2.getClientPortfolioLength()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
