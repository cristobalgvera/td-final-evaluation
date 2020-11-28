package cl.crisgvera.tdapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@Data
public class Order {

    @Id
    @GeneratedValue(generator = "ORDER_SEQUENCE")
    @Column(name = "ORDERNUMBER", precision = 10)
    private Long id;

    @Column(name = "ORDERDATE")
    private LocalDateTime orderDate;

    @Column(name = "REQUIREDDATE")
    private LocalDateTime requiredDate;

    @Column(name = "SHIPPEDDATE")
    private LocalDateTime shippedDate;

    @Column(length = 15)
    private String status;

    @Lob
    private String comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CUSTOMERNUMBER")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new HashSet<>();

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        orderDetails.remove(orderDetail);
        orderDetail.setOrder(null);
    }

}
