package com.example.laboratorinis_psk.usecases;


import com.example.laboratorinis_psk.entities.CoffeeShop;
import com.example.laboratorinis_psk.persistence.ShopsDAO;
import lombok.Getter;
import lombok.Setter;
import com.example.laboratorinis_psk.interceptors.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateShopDetails implements Serializable {

    private CoffeeShop shop;

    @Inject
    private ShopsDAO shopsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateShopDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer shopId = Integer.parseInt(requestParameters.get("shopId"));
        this.shop = shopsDAO.findOne(shopId);
    }

    @Transactional
    @LoggedInvocation
    public String updateShop() {
        try{
            shopsDAO.update(this.shop);
        } catch (OptimisticLockException e) {
            return "/menu.xhtml?faces-redirect=true&shopId=" + this.shop.getId() + "&error=optimistic-lock-exception";
        }
        return "menu.xhtml?shopId=" + this.shop.getId() + "&faces-redirect=true";
    }
}
