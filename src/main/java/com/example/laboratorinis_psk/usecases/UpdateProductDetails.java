package com.example.laboratorinis_psk.usecases;


import lombok.Getter;
import lombok.Setter;
import com.example.laboratorinis_psk.entities.Product;
import com.example.laboratorinis_psk.interceptors.LoggedInvocation;
import com.example.laboratorinis_psk.persistence.ProductsDAO;

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
public class UpdateProductDetails implements Serializable {

    private Product product;

    @Inject
    private ProductsDAO productsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateProductDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer productId = Integer.parseInt(requestParameters.get("productId"));
        this.product = productsDAO.findOne(productId);
    }

    @Transactional
    @LoggedInvocation
    public String updateProduct() {
        try{
            productsDAO.update(this.product);
        } catch (OptimisticLockException e) {
            return "/productDetails.xhtml?faces-redirect=true&productId=" + this.product.getId() + "&error=optimistic-lock-exception";
        }
        return "menu.xhtml?shopId=" + this.product.getShop().getId() + "&faces-redirect=true";
    }
}
