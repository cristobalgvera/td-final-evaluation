package cl.crisgvera.tdapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OFFICES")
@Data
public class Office {

    @Id
    @Column(name = "OFFICECODE", length = 10)
    private String id;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String phone;

    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressLine1;

    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressLine2;

    @Column(length = 50)
    private String state;

    @Column(length = 50)
    private String country;

    @Column(name = "POSTALCODE", length = 15)
    private String postalCode;

    @Column(length = 10)
    private String territory;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setOffice(this);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.setOffice(null);
    }

}
