package com.brevitaz.dao;

import com.brevitaz.model.SalaryStructure;
import java.util.List;

public interface SalaryStructureDao
{
    public boolean create(SalaryStructure salaryStructure) ;
    public List<SalaryStructure> getAll() ;
    public boolean update(String id,SalaryStructure salaryStructure) ;
   // public boolean delete(String id);
    public SalaryStructure getLatestSalaryStructure();
    public SalaryStructure getById(String id);
}
