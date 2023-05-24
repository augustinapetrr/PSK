package com.example.laboratorinis_psk.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class EmployeesNumberGenerator implements Serializable {

    public Integer generateEmployeesNumber() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer generatedEmployeesNumber = new Random().nextInt(100);
        return generatedEmployeesNumber;
    }
}