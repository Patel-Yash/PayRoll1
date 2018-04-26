package com.brevitaz.service;

import com.brevitaz.model.Employee;

import java.util.List;

public interface EmployeeService
{
    public boolean create(Employee employee);
    public boolean delete(String id);
    public boolean update(String id,Employee employee);
    public Employee getById(String id);
    public List<Employee> getAll();
}
