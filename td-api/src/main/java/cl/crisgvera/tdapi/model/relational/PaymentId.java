package cl.crisgvera.tdapi.model.relational;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PaymentId implements Serializable {

    @Column(name = "CHECKNUMBER", length = 50)
    private String checkNumberId;

    @Column(name = "CUSTOMERNUMBER")
    private Long customerNumberId;

}
