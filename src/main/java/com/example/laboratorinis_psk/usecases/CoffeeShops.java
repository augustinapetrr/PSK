package com.example.laboratorinis_psk.usecases;

import com.example.laboratorinis_psk.interceptors.LoggedInvocation;
import com.example.laboratorinis_psk.entities.CoffeeShop;
import com.example.laboratorinis_psk.qualifiers.LocalShop;
import com.example.laboratorinis_psk.qualifiers.LocalShopType;
import com.example.laboratorinis_psk.qualifiers.ShopTypeProcessor;
import lombok.Getter;
import lombok.Setter;
import com.example.laboratorinis_psk.persistence.ShopsDAO;
import com.example.laboratorinis_psk.alternatives.Message;
import com.example.laboratorinis_psk.decorators.ShopDecorator;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import javax.enterprise.inject.Any;
import java.util.stream.Collectors;

@Model
public class CoffeeShops {

    @Inject
    private ShopsDAO shopsDAO;

    @Inject @LocalShop
    ShopTypeProcessor shopTypeProcessor;

    @Inject @Any
    private LocalShopType localShopType;

    @Getter @Setter
    private CoffeeShop shopToCreate = new CoffeeShop();

    @Getter
    private List<CoffeeShop> allShops;

    @Getter
    private List<CoffeeShop> localShops;

    @Inject
    private Message message;

    @Inject
    private ShopDecorator shopDecorator;

    @PostConstruct
    public void init(){
        loadAllShops();
        //loadLocalShops();
    }

    @Transactional
    @LoggedInvocation
    public void createShop(){
        this.shopsDAO.persist(shopToCreate);
        System.out.println(message.WriteMessage());
        System.out.println("Decorator implementation: " + shopDecorator.DecoratedInt(26));
        System.out.println(shopTypeProcessor.ShopType());
        System.out.println(localShopType.ShopType());
    }

    private void loadAllShops(){
        this.allShops = shopsDAO.loadAll();
    }

    public void loadLocalShops() {
        List<CoffeeShop> shops = shopsDAO.loadAll();
        this.localShops = shops.stream()
                .filter(s -> s.getName().toUpperCase().contains("LOCAL"))
                .collect(Collectors.toList());
    }
}
