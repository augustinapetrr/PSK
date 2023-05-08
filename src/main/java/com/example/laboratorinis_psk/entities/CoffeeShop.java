package com.example.laboratorinis_psk.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
        @NamedQuery(name = "CoffeeShop.findAll", query = "select s from CoffeeShop as s")
})
@Table(name = "COFFEESHOP")
@Getter @Setter
public class CoffeeShop {

    public CoffeeShop(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /*@Basic (optional = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    //private List<Product> products;

    @OneToMany (mappedBy = "shop")
    private List<Product> products = new ArrayList<>();
    /*public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }*/

    //private List<Supplier> suppliers;

    @ManyToMany (mappedBy = "shops")
    private List<Supplier> suppliers = new ArrayList<>();
    /*public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeShop shop = (CoffeeShop) o;
        return Objects.equals(name, shop.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
