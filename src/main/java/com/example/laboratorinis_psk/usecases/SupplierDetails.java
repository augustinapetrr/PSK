package com.example.laboratorinis_psk.usecases;


import com.example.laboratorinis_psk.entities.Supplier;
import com.example.laboratorinis_psk.interceptors.LoggedInvocation;
import com.example.laboratorinis_psk.persistence.SuppliersDAO;
import lombok.Getter;
import lombok.Setter;

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
public class SupplierDetails implements Serializable {

    private Supplier supplier;

    @Inject
    private SuppliersDAO suppliersDAO;

    @PostConstruct
    private void init() {
        System.out.println("SupplierDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer supplierId = Integer.parseInt(requestParameters.get("supplierId"));
        this.supplier = suppliersDAO.findOne(supplierId);
    }
}
