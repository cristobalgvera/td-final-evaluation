package cl.crisgvera.tdapi.controller;

import cl.crisgvera.tdapi.dto.BCustomerDto;
import cl.crisgvera.tdapi.dto.ECustomerDto;
import cl.crisgvera.tdapi.model.Customer;
import cl.crisgvera.tdapi.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get-by")
    public Collection<BCustomerDto> getAllCustomersByNameContains(@RequestParam(defaultValue = "Ltd") String nameContains) {
        return customerService.getAllCustomersByNameContains(nameContains);
    }

    @GetMapping("/get-by/orders")
    public Collection<ECustomerDto> getAllCustomersOrdersTotalFilteredByYear(@RequestParam(defaultValue = "2004") int year) {
        return customerService.getAllCustomersOrdersTotalFilteredByYear(year);
    }
}
