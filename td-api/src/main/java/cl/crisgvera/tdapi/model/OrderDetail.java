package cl.crisgvera.tdapi.model;

import cl.crisgvera.tdapi.model.relational.OrderDetailId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ORDERDETAILS")
@Data
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne(optional = false, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @MapsId("ORDERNUMBER")
    @JoinColumn(name = "ORDERNUMBER")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Order order;

    @ManyToOne(optional = false, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @MapsId("PRODUCTCODE")
    @JoinColumn(name = "PRODUCTCODE")
    private Product product;

    @Column(name = "QUANTITYORDERED", precision = 5)
    private short quantityOrdered;

    @Column(name = "PRICEEACH", precision = 7, scale = 2)
    private double priceEach;

    @Column(name = "ORDERLINENUMBER", precision = 3)
    private byte orderLineNumber;

}
