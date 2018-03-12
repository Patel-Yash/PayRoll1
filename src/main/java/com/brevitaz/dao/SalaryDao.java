package com.brevitaz.dao;

import com.brevitaz.model.Salary;
import java.util.List;

public interface SalaryDao
{
    public boolean create(Salary salary) ;
    public List<Salary> getAll() ;
    public boolean update(Salary salary,String id) ;
    public boolean delete(String id);
    public Salary getById(String id);
}
