package com.example.laboratorinis_psk.usecases;

import com.example.laboratorinis_psk.entities.CoffeeShop;
import lombok.Getter;
import lombok.Setter;
import com.example.laboratorinis_psk.persistence.ShopsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CoffeeShops {

    @Inject
    private ShopsDAO shopsDAO;

    @Getter @Setter
    private CoffeeShop shopToCreate = new CoffeeShop();

    @Getter
    private List<CoffeeShop> allShops;

    @PostConstruct
    public void init(){
        loadAllShops();
    }

    @Transactional
    public void createShop(){
        this.shopsDAO.persist(shopToCreate);
    }

    private void loadAllShops(){
        this.allShops = shopsDAO.loadAll();
    }
}
