package cl.crisgvera.tdapi.service;

import cl.crisgvera.tdapi.dto.BCustomerDto;
import cl.crisgvera.tdapi.dto.ECustomerDto;
import cl.crisgvera.tdapi.model.Customer;
import cl.crisgvera.tdapi.model.Order;
import cl.crisgvera.tdapi.model.OrderDetail;
import cl.crisgvera.tdapi.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Collection<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Collection<BCustomerDto> getAllCustomersByNameContains(String nameContains) {
        log.info("[CustomerService] getAllCustomersByNameContains | nameContains = " + nameContains);
        Collection<Customer> customers = customerRepository.findCustomersByNameContains(nameContains);
        return customers.stream()
                .map(customer -> BCustomerDto.builder()
                        .customerNumber(customer.getId())
                        .customerName(customer.getName())
                        .creditLimit(customer.getCreditLimit())
                        .build())
                .sorted((o1, o2) -> Math.max(o1.getCreditLimit(), o2.getCreditLimit()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Collection<ECustomerDto> getAllCustomersOrdersTotalFilteredByYear(int year) {
        Collection<Customer> customers = findAll();
        return customers.stream()
                .map(customer -> ECustomerDto.builder()
                        .customerName(customer.getName())
                        .sumOfOrdersTotal(getOrdersTotal(customer, year))
                        .build())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private Double getOrdersTotal(Customer customer, int filterYear) {
        return customer.getOrders()
                .stream()
                .filter(order -> order.getOrderDate().getYear() == filterYear)
                .map(order -> order.getOrderDetails()
                        .stream()
                        .map(orderDetail -> orderDetail.getPriceEach() * orderDetail.getQuantityOrdered())
                        .reduce(0D, Double::sum))
                .reduce(0D, Double::sum);
    }
}
