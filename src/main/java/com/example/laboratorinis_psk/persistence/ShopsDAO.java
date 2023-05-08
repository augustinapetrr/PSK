package com.example.laboratorinis_psk.persistence;

import com.example.laboratorinis_psk.entities.CoffeeShop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ShopsDAO {

    @Inject
    private EntityManager em;

    public List<CoffeeShop> loadAll() {
        return em.createNamedQuery("CoffeeShop.findAll", CoffeeShop.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(CoffeeShop shop){
        this.em.persist(shop);
    }

    public CoffeeShop findOne(Integer id) {
        return em.find(CoffeeShop.class, id);
    }
}
