package com.example.laboratorinis_psk.usecases;


import com.example.laboratorinis_psk.entities.CoffeeShop;
import com.example.laboratorinis_psk.entities.Supplier;
import com.example.laboratorinis_psk.interceptors.LoggedInvocation;
import com.example.laboratorinis_psk.persistence.ShopsDAO;
import com.example.laboratorinis_psk.persistence.SuppliersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.swing.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.List;
@ViewScoped
@Named
@Getter @Setter
public class UpdateSupplierDetails implements Serializable {

    private Supplier supplier;

    @Inject
    private SuppliersDAO suppliersDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateSupplierDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer supplierId = Integer.parseInt(requestParameters.get("supplierId"));
        this.supplier = suppliersDAO.findOne(supplierId);
    }

    private CoffeeShop shop;
    private Integer newShop;
    @Inject
    private ShopsDAO shopsDAO;

    @Transactional
    @LoggedInvocation
    public String updateSupplier() {
        try{
            shop = shopsDAO.findOne(newShop);
            List supplierShops = supplier.getShops();
            if(!supplierShops.contains(shop))
                supplierShops.add(shop);
                supplier.setShops(supplierShops);
                suppliersDAO.update(this.supplier);
        } catch (OptimisticLockException e) {
            return "/supplierDetails.xhtml?faces-redirect=true&supplierId=" + this.supplier.getId() + "&error=optimistic-lock-exception";
        }
        return "/supplierDetails.xhtml?faces-redirect=true&supplierId=" + this.supplier.getId();
    }
}
