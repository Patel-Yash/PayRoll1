package com.brevitaz.dao;

import com.brevitaz.model.SalaryDeductionComponent;
import java.util.List;

public interface SalaryDeductionComponentDao
{
    public boolean create(SalaryDeductionComponent salaryDeductionComponent);
    public List<SalaryDeductionComponent> getAll() ;
    public boolean update(SalaryDeductionComponent salaryDeductionComponent,String id) ;
    public boolean delete(String id);
    public SalaryDeductionComponent getById(String id);
}
