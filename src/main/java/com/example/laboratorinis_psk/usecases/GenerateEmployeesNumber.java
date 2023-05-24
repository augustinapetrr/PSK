package com.example.laboratorinis_psk.usecases;

import com.example.laboratorinis_psk.services.EmployeesNumberGenerator;
import com.example.laboratorinis_psk.interceptors.LoggedInvocation;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateEmployeesNumber implements Serializable {
    @Inject
    EmployeesNumberGenerator employeesNumberGenerator;

    private CompletableFuture<Integer> employeesNumberGenerationTask = null;

    @LoggedInvocation
    public String generateNewEmployeesNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        employeesNumberGenerationTask = CompletableFuture.supplyAsync(() -> employeesNumberGenerator.generateEmployeesNumber());

        return  "menu.xhtml?shopId=" + requestParameters.get("shopId") + "&faces-redirect=true";
    }

    public boolean isEmployeesGenerationRunning() {
        return employeesNumberGenerationTask != null && !employeesNumberGenerationTask.isDone();
    }

    public String getEmployeesGenerationStatus() throws ExecutionException, InterruptedException {
        if (employeesNumberGenerationTask == null) {
            return null;
        } else if (isEmployeesGenerationRunning()) {
            return "Employees generation in progress";
        }
        return "Suggested employees number: " + employeesNumberGenerationTask.get();
    }
}
