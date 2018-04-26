package com.brevitaz.service;

import com.brevitaz.model.SalarySlip;

import java.util.List;

public interface SalarySlipService
{
    public boolean create(SalarySlip salarySlip);
    public List<SalarySlip> getAll() ;
    public boolean update(String id,SalarySlip salarySlip) ;
    public boolean delete(String id);
    public SalarySlip getById(String id);
    public List<SalarySlip> getByEmployeeId(String employeeId);
    public List<SalarySlip> getByMonth(String month);
    public SalarySlip getLatestSalarySlip(String employeeId);

}
