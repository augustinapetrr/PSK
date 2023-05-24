package com.example.laboratorinis_psk.alternatives;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Dependent
@Alternative
public class AltMessage implements Message{

    @Override
    public String WriteMessage() {
        return "Alternative shop created";
    }

    public AltMessage() {

    }
}