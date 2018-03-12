package com.brevitaz.dao;

import com.brevitaz.model.SalaryStructureComponent;
import java.util.List;

public interface SalaryStructureComponentDao
{
    public boolean create(SalaryStructureComponent salaryStructureComponent) ;
    public List<SalaryStructureComponent> getAll();
    public boolean update(SalaryStructureComponent salaryStructureComponent,String id);
    public boolean delete(String id);
    public SalaryStructureComponent getById(String id);
}
