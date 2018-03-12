package com.brevitaz.model;

import java.util.Date;

public class Salary {

    private String id;
    private String employeeId;
    private String salaryStructureId;
    private double grossSalary;
    private double variablePay;
    private double otherAllowance;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}

