package cl.crisgvera.tdapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "EMPLOYEE_SEQUENCE")
    @Column(name = "EMPLOYEENUMBER", precision = 10)
    private Long id;

    @Column(name = "LASTNAME", length = 50)
    private String lastName;

    @Column(name = "FIRSTNAME", length = 50)
    private String firstName;

    @Column(length = 10)
    private String extension;

    @Column(length = 100)
    private String email;

    @Column(name = "JOBTITLE", length = 50)
    private String jobTitle;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "childEmployees", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Employee> childEmployees = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "REPORTSTO")
    private Employee parentEmployee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "OFFICECODE")
    private Office office;

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setEmployee(this);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.setEmployee(null);
    }

}
