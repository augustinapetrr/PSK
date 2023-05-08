package com.example.laboratorinis_psk.persistence;

import com.example.laboratorinis_psk.entities.Supplier;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SuppliersDAO {

    @Inject
    private EntityManager em;

    public List<Supplier> loadAll() {
        return em.createNamedQuery("Supplier.findAll", Supplier.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Supplier supplier){
        this.em.persist(supplier);
    }

    public Supplier findOne(Integer id) {
        return em.find(Supplier.class, id);
    }
}
