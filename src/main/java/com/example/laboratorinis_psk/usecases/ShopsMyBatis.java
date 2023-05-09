package com.example.laboratorinis_psk.usecases;

import com.example.laboratorinis_psk.mybatis.dao.CoffeeshopMapper;
import com.example.laboratorinis_psk.mybatis.model.Coffeeshop;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ShopsMyBatis {
    @Inject
    private CoffeeshopMapper shopMapper;

    @Getter
    private List<Coffeeshop> allShops;

    @Getter @Setter
    private Coffeeshop shopToCreate = new Coffeeshop();

    @PostConstruct
    public void init() {
        this.loadAllShops();
    }

    private void loadAllShops() {
        this.allShops = shopMapper.selectAll();
    }

    @Transactional
    public String createShop() {
        shopMapper.insert(shopToCreate);
        return "/myBatis/shops?faces-redirect=true";
    }
}
