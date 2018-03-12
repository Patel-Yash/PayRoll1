package com.brevitaz.model;

import java.util.List;

public class SalaryStructure {

    private String id;
    private List<SalaryStructureComponent> salaryStructureComponents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SalaryStructureComponent> getSalaryStructureComponents() {
        return salaryStructureComponents;
    }

    public void setSalaryStructureComponents(List<SalaryStructureComponent> salaryStructureComponents) {
        this.salaryStructureComponents = salaryStructureComponents;
    }

    @Override
    public String toString() {
        return "SalaryStructure{" +
                "id='" + id + '\'' +
                ", salaryStructureComponents=" + salaryStructureComponents +
                '}';
    }
}
