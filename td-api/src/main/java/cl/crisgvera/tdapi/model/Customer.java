package cl.crisgvera.tdapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
@Data
public class Customer {

    @Id
    @GeneratedValue(generator = "CUSTOMER_SEQUENCE")
    @Column(name = "CUSTOMERNUMBER", precision = 10)
    private Long id;

    @Column(name = "CUSTOMERNAME", length = 50)
    private String name;

    @Column(name = "CONTACTLASTNAME", length = 50)
    private String lastName;

    @Column(name = "CONTACTFIRSTNAME", length = 50)
    private String firstName;

    @Column(length = 50)
    private String phone;

    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressLine1;

    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressLine2;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 50)
    private String country;

    @Column(name = "POSTALCODE", length = 15)
    private String postalCode;

    @Column(name = "CREDITLIMIT", precision = 10)
    private int creditLimit;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> payments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "SALESREPEMPLOYEENUMBER")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Employee employee;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setCustomer(this);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
        payment.setCustomer(null);
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCustomer(null);
    }

}
