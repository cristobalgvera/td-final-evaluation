package cl.crisgvera.tdapi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CEmployeeDto {
    Long employeeNumber;
    String firstName, lastName;
    long clientPortfolioLength;
}
