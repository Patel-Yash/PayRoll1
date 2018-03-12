package com.brevitaz.model;

import java.util.List;

public class SalarySlip {
    private String id;
    private String employeeId;
    private double variablePay;

    private List<SalaryDeductionComponent> salaryDeductionComponents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(double variablePay) {
        this.variablePay = variablePay;
    }

    public List<SalaryDeductionComponent> getSalaryDeductionComponents() {
        return salaryDeductionComponents;
    }

    public void setSalaryDeductionComponents(List<SalaryDeductionComponent> salaryDeductionComponents) {
        this.salaryDeductionComponents = salaryDeductionComponents;
    }

    @Override
    public String toString() {
        return "SalarySlip{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", variablePay=" + variablePay +
                ", salaryDeductionComponents=" + salaryDeductionComponents +
                '}';
    }
}
