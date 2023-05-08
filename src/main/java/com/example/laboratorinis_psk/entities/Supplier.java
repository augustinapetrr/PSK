package com.example.laboratorinis_psk.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
        @NamedQuery(name = "Supplier.findAll", query = "select su from Supplier as su")
})
@Table(name = "SUPPLIER")
@Getter @Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Size(max = 50)
    @Column(name = "COFFEETYPE")
    private String type;

    @Column(name = "COUNTRY")
    private String country;

    @ManyToMany
    @JoinTable(name = "SUPPLIER_COFFEESHOP",
            joinColumns = @JoinColumn(name = "suppliers_id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private List<CoffeeShop> shops = new ArrayList<>();

    /*
    @JoinColumn(name="SHOP_ID")
    private CoffeeShop shop;*/

    public Supplier() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id) &&
                Objects.equals(name, supplier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /*private String name;

    @Basic (optional = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String country;

    @Basic (optional = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String coffeeType;

    @Basic
    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    private List<CoffeeShop> shop;

    @ManyToMany
    public List<CoffeeShop> getShop() {
        return shop;
    }

    public void setShop(List<CoffeeShop> shop) {
        this.shop = shop;
    }*/
}
