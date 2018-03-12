package com.brevitaz.model;

import java.util.Date;
import java.util.List;

public class SalaryStructure {

    private String id;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private List<SalaryIncomeComponent> salaryIncomeComponents;
    private List<SalaryDeductionComponent> salaryDeductionComponents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "SalaryStructure{" +
                "id='" + id + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", salaryIncomeComponents=" + salaryIncomeComponents +
                ", salaryDeductionComponents=" + salaryDeductionComponents +
                '}';
    }
}
