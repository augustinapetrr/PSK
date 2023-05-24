package com.example.laboratorinis_psk.alternatives;

import javax.enterprise.context.Dependent;

@Dependent
public class ShopMessage implements Message{

    @Override
    public String WriteMessage() {
        return "Shop created";
    }

    public ShopMessage() {

    }
}