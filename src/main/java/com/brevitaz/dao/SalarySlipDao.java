package com.brevitaz.dao;


import com.brevitaz.model.SalarySlip;

import java.util.List;

public interface SalarySlipDao
{
    public boolean create(SalarySlip salarySlip);
    public List<SalarySlip> getAll() ;
    public boolean update(SalarySlip salarySlip,String id) ;
    public boolean delete(String id);
    public SalarySlip getById(String id);
}
