package com.brevitaz.model;

public class Salary {

    private String id;
    private String employeeId;
    private String salaryStructureId;
    private double grossSalary;
    private double variablePay;
    private double otherAllowance;

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

    public String getSalaryStructureId() {
        return salaryStructureId;
    }

    public void setSalaryStructureId(String salaryStructureId) {
        this.salaryStructureId = salaryStructureId;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(double variablePay) {
        this.variablePay = variablePay;
    }

    public double getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(double otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", salaryStructureId='" + salaryStructureId + '\'' +
                ", grossSalary=" + grossSalary +
                ", variablePay=" + variablePay +
                ", otherAllowance=" + otherAllowance +
                '}';
    }
}

