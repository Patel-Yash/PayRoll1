package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import java.util.List;

public interface EmployeeDao
{
    public boolean create(Employee employee);
    public List<Employee> getAll();
    public boolean update(String id,Employee employee);
    public boolean delete(String id);
    public Employee getById(String id);
}
