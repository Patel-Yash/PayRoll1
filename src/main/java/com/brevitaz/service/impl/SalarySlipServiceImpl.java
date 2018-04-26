package com.brevitaz.service.impl;

import com.brevitaz.dao.SalarySlipDao;
import com.brevitaz.errors.InvalidIdException;
import com.brevitaz.model.SalarySlip;
import com.brevitaz.model.Status;
import com.brevitaz.service.SalaryService;
import com.brevitaz.service.SalarySlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarySlipServiceImpl implements SalarySlipService
{
    @Autowired
    private SalarySlipDao salarySlipDao;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private SalarySlipService salarySlipService;

    @Override
    public boolean create(SalarySlip salarySlip)//TODO:Integrate with LM module.
    {
        return false;
    }

    @Override
    public boolean delete(String id)
    {
        SalarySlip salarySlip = salarySlipDao.getById(id);
        if (salarySlip == null)
        {
            throw new InvalidIdException("Salary doesn't exists!!!");
        }
        else
        {
            salarySlip.setStatus(Status.CANCELLED);
            return salarySlipDao.update(id,salarySlip);
        }
    }

    @Override
    public boolean update( String id,SalarySlip salarySlip)//TODO:Remaining!!
    {
        SalarySlip salarySlip1 = salarySlipDao.getById(id);
        if (salarySlip1.getStatus()!=Status.CANCELLED &&
                salarySlip.getStatus() !=Status.CANCELLED)
        {
            if (salarySlip.getVariablePay()!=salarySlip1.getVariablePay())
            {
                return salarySlipDao.update(id,salarySlip);
            }
            else
            {
                return salarySlipService.create(salarySlip);
            }
        }
        else
        {
            throw new InvalidIdException("Update not done!!!");
        }
    }

    @Override
    public SalarySlip getById(String id)
    {
        return salarySlipDao.getById(id);
    }

    @Override
    public List<SalarySlip> getByEmployeeId(String employeeId) {
        return salarySlipDao.getByEmployeeId(employeeId);
    }

    @Override
    public List<SalarySlip> getByMonth(String month) {
        return salarySlipDao.getByMonth(month);
    }

    @Override
    public SalarySlip getLatestSalarySlip(String employeeId) {
        List<SalarySlip> salarySlips= salarySlipDao.getByEmployeeId(employeeId);
        return salarySlipDao.getLatestSalarySlip(salarySlips);
    }

    @Override
    public List<SalarySlip> getAll()
    {
        return salarySlipDao.getAll();
    }
}
