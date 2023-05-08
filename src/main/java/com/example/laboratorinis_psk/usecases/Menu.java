package com.example.laboratorinis_psk.usecases;

import lombok.Getter;
import lombok.Setter;
import com.example.laboratorinis_psk.entities.CoffeeShop;
import com.example.laboratorinis_psk.entities.Product;
import com.example.laboratorinis_psk.interceptors.LoggedInvocation;
import com.example.laboratorinis_psk.persistence.ShopsDAO;
import com.example.laboratorinis_psk.persistence.ProductsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class Menu implements Serializable {

    @Inject
    private ShopsDAO shopsDAO;

    @Inject
    private ProductsDAO productsDAO;

    @Getter @Setter
    private CoffeeShop shop;

    @Getter @Setter
    private Product productToCreate = new Product();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer shopId = Integer.parseInt(requestParameters.get("shopId"));
        this.shop = shopsDAO.findOne(shopId);
    }

    @Transactional
    @LoggedInvocation
    public void createProduct() {
        productToCreate.setShop(this.shop);
        productsDAO.persist(productToCreate);
    }
}
