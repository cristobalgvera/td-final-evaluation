package cl.crisgvera.tdapi.service;

import cl.crisgvera.tdapi.dto.DOfficeDto;
import cl.crisgvera.tdapi.model.Customer;
import cl.crisgvera.tdapi.model.Office;
import cl.crisgvera.tdapi.repository.OfficeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Service
@Log4j2
public class OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Collection<Office> findAll() {
        return officeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Office::getCity))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Collection<DOfficeDto> getAllOfficesOrdersAmount() {
        log.info("[OfficeService] getAllOfficesOrdersAmount");
        Collection<Office> offices = officeRepository.findAll();
        return offices.stream()
                .map(office -> DOfficeDto.builder()
                        .country(office.getCountry())
                        .city(office.getCity())
                        .totalOrdersAmount(getTotalOrdersAmount(office))
                        .build())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private long getTotalOrdersAmount(Office office) {
        log.info("[OfficeService] _getTotalOrdersAmount");
        return office.getEmployees().stream()
                .map(employee -> (int) employee.getCustomers()
                        .stream()
                        .map(Customer::getOrders)
                        .count())
                .reduce(0, Integer::sum);
    }
}
