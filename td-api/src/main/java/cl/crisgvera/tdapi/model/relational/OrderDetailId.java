package cl.crisgvera.tdapi.model.relational;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderDetailId implements Serializable {

    @Column(name = "ORDERNUMBER")
    private Long orderNumberId;

    @Column(name = "PRODUCTCODE", length = 15)
    private String productCodeId;

}
