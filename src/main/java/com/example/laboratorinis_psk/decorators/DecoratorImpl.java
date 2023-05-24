package com.example.laboratorinis_psk.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorImpl implements ShopDecorator{

    @Inject @Delegate @Any
    ShopDecorator shopDecorator;

    public Integer DecoratedInt(Integer integer){
        System.out.println("Decorator is used");
        return shopDecorator.DecoratedInt(integer) * 10;
    }

}