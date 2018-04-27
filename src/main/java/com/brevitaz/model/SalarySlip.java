package com.brevitaz.model;

import java.util.Date;
import java.util.List;

public class SalarySlip {
    private String id;
    private String employeeId;
    private String salaryId;
    private String month;
    private double variablePay;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private Status status;
    private String type;
    private double netMonthlySalary;
    private double monthlySalary;
    private List<SalaryIncomeComponent> salaryIncomeComponents;
    private List<SalaryDeductionComponent> salaryDeductionComponents;
    private String employeeName;
    private String employeeDepartment;
    private Date employeeDateOfJoining;
    private String employeeDesignation;
    private String employeeLocation;
    private double nonPayableAmount;

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

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(double variablePay) {
        this.variablePay = variablePay;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getNetMonthlySalary() {
        return netMonthlySalary;
    }

    public void setNetMonthlySalary(double netMonthlySalary) {
        this.netMonthlySalary = netMonthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public List<SalaryIncomeComponent> getSalaryIncomeComponents() {
        return salaryIncomeComponents;
    }

    public void setSalaryIncomeComponents(List<SalaryIncomeComponent> salaryIncomeComponents) {
        this.salaryIncomeComponents = salaryIncomeComponents;
    }

    public List<SalaryDeductionComponent> getSalaryDeductionComponents() {
        return salaryDeductionComponents;
    }

    public void setSalaryDeductionComponents(List<SalaryDeductionComponent> salaryDeductionComponents) {
        this.salaryDeductionComponents = salaryDeductionComponents;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public Date getEmployeeDateOfJoining() {
        return employeeDateOfJoining;
    }

    public void setEmployeeDateOfJoining(Date employeeDateOfJoining) {
        this.employeeDateOfJoining = employeeDateOfJoining;
    }

    public double getNonPayableAmount() {
        return nonPayableAmount;
    }

    public void setNonPayableAmount(double nonPayableAmount) {
        this.nonPayableAmount = nonPayableAmount;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeLocation() {
        return employeeLocation;
    }

    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation;
    }


    @Override
    public String toString() {
        return "SalarySlip{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", salaryId='" + salaryId + '\'' +
                ", month='" + month + '\'' +
                ", variablePay=" + variablePay +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", netMonthlySalary=" + netMonthlySalary +
                ", monthlySalary=" + monthlySalary +
                ", salaryIncomeComponents=" + salaryIncomeComponents +
                ", salaryDeductionComponents=" + salaryDeductionComponents +
                ", employeeName='" + employeeName + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeDateOfJoining=" + employeeDateOfJoining +
                ", employeeDesignation='" + employeeDesignation + '\'' +
                ", employeeLocation='" + employeeLocation + '\'' +
                ", nonPayableAmount=" + nonPayableAmount +
                '}';
    }
}
