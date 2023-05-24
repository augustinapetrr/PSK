package com.example.laboratorinis_psk.qualifiers;

import javax.enterprise.context.Dependent;

@LocalShop
@Dependent
public class LocalShopType implements ShopTypeProcessor{

    @Override
    public String ShopType() {
        return "Shop type is LOCAL";
    }
}