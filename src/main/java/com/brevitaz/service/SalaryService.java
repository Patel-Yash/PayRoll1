package com.brevitaz.service;

import com.brevitaz.model.Salary;

import java.util.List;

public interface SalaryService
{
    public boolean create(Salary salary);
    public boolean delete(String id);
    public boolean update(String id,Salary salary);
    public Salary getById(String id);
    public List<Salary> getAll();
    public Salary getLatestSalary(String employeeId);
    public List<Salary> getByEmployeeId(String employeeId);

}
