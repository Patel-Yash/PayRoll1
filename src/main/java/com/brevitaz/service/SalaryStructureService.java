package com.brevitaz.service;

import com.brevitaz.model.SalaryStructure;

import java.util.List;

public interface SalaryStructureService
{
    public boolean create(SalaryStructure salaryStructure);
    public boolean delete(String id);
    public boolean update(String id,SalaryStructure salaryStructure);
    public SalaryStructure getById(String id);
    public SalaryStructure getLatestSalaryStructure();
    public List<SalaryStructure> getAll();
}
