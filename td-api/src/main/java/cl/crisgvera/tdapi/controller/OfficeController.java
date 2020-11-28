package cl.crisgvera.tdapi.controller;

import cl.crisgvera.tdapi.dto.DOfficeDto;
import cl.crisgvera.tdapi.model.Office;
import cl.crisgvera.tdapi.service.OfficeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public Collection<Office> findAll() {
        return officeService.findAll();
    }

    @GetMapping("/get-all-filtered-by-orders-amount")
    public Collection<DOfficeDto> getAllOfficesOrdersAmount() {
        return officeService.getAllOfficesOrdersAmount();
    }
}
