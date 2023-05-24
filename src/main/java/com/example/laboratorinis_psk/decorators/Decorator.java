package com.example.laboratorinis_psk.decorators;

import javax.enterprise.context.Dependent;

@Dependent
public class Decorator implements ShopDecorator{

    @Override
    public Integer DecoratedInt(Integer integer) {
        return integer;
    }
}