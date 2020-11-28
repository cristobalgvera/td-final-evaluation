package cl.crisgvera.tdapi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ECustomerDto {
    String customerName;
    double sumOfOrdersTotal;
}
