package cl.crisgvera.tdapi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AEmployeeDto {
    String lastName, firstName, email, officeCity, officeCountry;
}
