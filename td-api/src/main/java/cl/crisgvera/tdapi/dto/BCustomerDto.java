package cl.crisgvera.tdapi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BCustomerDto {
    Long customerNumber;
    String customerName;
    int creditLimit;
}
