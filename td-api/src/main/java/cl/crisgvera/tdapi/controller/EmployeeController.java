package cl.crisgvera.tdapi.controller;

import cl.crisgvera.tdapi.dto.AEmployeeDto;
import cl.crisgvera.tdapi.dto.CEmployeeDto;
import cl.crisgvera.tdapi.model.Employee;
import cl.crisgvera.tdapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> findAllByJobTitle(@RequestParam(defaultValue = "Sales Manager") String jobTitle) {
        return employeeService.findAllByJobTitle(jobTitle);
    }

    @GetMapping("/get-by")
    public Collection<AEmployeeDto> getAllEmployeesByJobTitle(@RequestParam(defaultValue = "Sales Rep") String jobTitle) {
        return employeeService.getAllEmployeesByJobTitleFilteredByADto(jobTitle);
    }

    @GetMapping("/get-by/job-title")
    public Collection<CEmployeeDto> getAllEmployeesByJobTitleFilteredByClientPortfolioLength(@RequestParam(defaultValue = "Sales Rep") String jobTitle,
                                                                                             @RequestParam(defaultValue = "portfolio") String filter) {
        return employeeService.getAllEmployeesByJobTitleFilteredByClientPortfolioLength(jobTitle);
    }
}
