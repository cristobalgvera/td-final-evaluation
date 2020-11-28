package cl.crisgvera.tdapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCTLINES")
@Data
public class ProductLine {

    @Id
    @Column(name = "PRODUCTLINE", length = 50)
    private String id;

    @OneToMany(mappedBy = "productLine", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    @Column(name = "TEXTDESCRIPTION", length = 4000)
    private String textDescription;

    @Lob
    @Column(name = "HTMLDESCRIPTION")
    private String htmlDescription;

    @Lob
    private byte[] image;

    public void addProduct(Product product) {
        products.add(product);
        product.setProductLine(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setProductLine(null);
    }

}
