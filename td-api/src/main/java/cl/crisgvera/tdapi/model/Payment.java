package cl.crisgvera.tdapi.model;

import cl.crisgvera.tdapi.model.relational.PaymentId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENTS")
@Data
public class Payment {

    @EmbeddedId
    private PaymentId paymentId = new PaymentId();

    @ManyToOne(optional = false)
    @MapsId("CUSTOMERNUMBER")
    @JoinColumn(name = "CUSTOMERNUMBER")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Customer customer;

    @Column(name = "PAYMENTDATE")
    private LocalDateTime paymentDate;

    @Column(precision = 8, scale = 2)
    private double amount;

}