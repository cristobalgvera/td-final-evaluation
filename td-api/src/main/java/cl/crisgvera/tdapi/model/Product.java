package cl.crisgvera.tdapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@Data
public class Product {

    @Id
    @Column(name = "PRODUCTCODE", length = 15)
    private String id;

    @Column(name = "PRODUCTNAME", length = 70)
    private String name;

    @Column(name = "PRODUCTSCALE", length = 10)
    private String scale;

    @Column(name = "PRODUCTVENDOR", length = 50)
    private String vendor;

    @Lob
    @Column(name = "PRODUCTDESCRIPTION")
    private String description;

    @Column(name = "QUANTITYINSTOCK", precision = 6)
    private short quatityInStock;

    @Column(name = "BUYPRICE", precision = 8, scale = 2)
    private double buyPrice;

    @Column(precision = 8, scale = 2)
    private double msrp;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCTLINE")
    private ProductLine productLine;

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
        orderDetail.setProduct(this);
    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        orderDetails.remove(orderDetail);
        orderDetail.setProduct(null);
    }

}
