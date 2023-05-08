package com.example.laboratorinis_psk.usecases;

import com.example.laboratorinis_psk.entities.Supplier;
import com.example.laboratorinis_psk.persistence.SuppliersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Suppliers {

    @Inject
    private SuppliersDAO suppliersDAO;

    @Getter @Setter
    private Supplier supplierToCreate = new Supplier();

    @Getter
    private List<Supplier> allSuppliers;

    @PostConstruct
    public void init(){
        loadAllSuppliers();
    }

    @Transactional
    public void createSupplier(){
        this.suppliersDAO.persist(supplierToCreate);
    }

    private void loadAllSuppliers(){
        this.allSuppliers = suppliersDAO.loadAll();
    }
}
