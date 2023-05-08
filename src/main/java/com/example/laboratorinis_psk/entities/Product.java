package com.example.laboratorinis_psk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select p from Product as p")
})
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //private String name;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Integer price;

    @ManyToOne
    @JoinColumn(name="SHOP_ID")
    private CoffeeShop shop;

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /*@Basic (optional = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    /*private String description;

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Float price;

    @Basic (optional = false)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    private CoffeeShop shop;

    @ManyToOne
    public CoffeeShop getShop() {
        return shop;
    }

    public void setShop(CoffeeShop manyToOne) {
        this.shop = manyToOne;
    }*/
}
