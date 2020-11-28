package cl.crisgvera.tdapi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DOfficeDto {
    String country, city;
    long totalOrdersAmount;
}
