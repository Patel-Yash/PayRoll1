package com.brevitaz.dao;


import com.brevitaz.model.SalarySlip;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SalarySlipDao
{
    public boolean create(SalarySlip salarySlip);
    public List<SalarySlip> getAll() ;
    public boolean update(String id,SalarySlip salarySlip) ;
    //public boolean delete(String id);
    public SalarySlip getById(String id);
    public List<SalarySlip> getByEmployeeId(String employeeId);
    public List<SalarySlip> getByMonth(String month);
    public SalarySlip getLatestSalarySlip(List<SalarySlip> salarySlips);



}
