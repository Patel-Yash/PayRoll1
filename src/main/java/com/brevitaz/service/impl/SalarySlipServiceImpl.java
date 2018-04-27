package com.brevitaz.service.impl;

import com.brevitaz.dao.SalarySlipDao;
import com.brevitaz.errors.InvalidIdException;
import com.brevitaz.model.*;
import com.brevitaz.service.EmployeeService;
import com.brevitaz.service.SalaryService;
import com.brevitaz.service.SalarySlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalarySlipServiceImpl implements SalarySlipService//TODO:validations remaining
{
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalarySlipDao salarySlipDao;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private SalarySlipService salarySlipService;

    @Override
    public boolean create(SalarySlip salarySlip)//TODO:Integrate with LM module.
    {
        Employee employee1 = employeeService.getById(salarySlip.getEmployeeId());
        if (employee1.getId().equals(salarySlip.getEmployeeId()))
        {
            Salary salary = salaryService.getLatestSalary(salarySlip.getEmployeeId());
            salarySlip.setNetMonthlySalary(salary.getGrossSalary()/12);

            salarySlip.setEmployeeName(employee1.getName());
            salarySlip.setEmployeeDateOfJoining(employee1.getDateOfJoining());
            salarySlip.setEmployeeDepartment(employee1.getDepartment());
            salarySlip.setEmployeeDesignation(employee1.getDesignation());
            salarySlip.setEmployeeLocation(employee1.getLocation());


            List<SalaryIncomeComponent> salaryIncomeComponents = new ArrayList<>();
            for (SalaryIncomeComponent sIC:salary.getSalaryIncomeComponents())
            {
                sIC.setAmount(sIC.getAmount()/12);
                salaryIncomeComponents.add(sIC);
            }
            System.out.println("SIC"+salaryIncomeComponents);

            List<SalaryDeductionComponent> salaryDeductionComponents = new ArrayList<>();
            for (SalaryDeductionComponent sDC:salary.getSalaryDeductionComponents())
            {
                sDC.setAmount(sDC.getAmount()/12);
                salaryDeductionComponents.add(sDC);
            }
            System.out.println("SDC"+salaryDeductionComponents);


            double totalDeductionAmount = 0;

            for (SalaryDeductionComponent salaryDeductionComponent:salaryDeductionComponents)
            {
                totalDeductionAmount+=salaryDeductionComponent.getAmount();
            }
            System.out.println(totalDeductionAmount);

            salarySlip.setNonPayableAmount(totalDeductionAmount);

            salarySlip.setMonthlySalary(salarySlip.getNetMonthlySalary()-totalDeductionAmount+salarySlip.getVariablePay());

            System.out.println(salarySlip.getMonthlySalary());

            return salarySlipDao.create(salarySlip);
        }
        else
        {
            throw new InvalidIdException("Employee Doesn't exists!!");
        }
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
    public boolean update( String id,SalarySlip salarySlip)
    {
        SalarySlip salarySlip1 = salarySlipDao.getById(id);
        if (salarySlip1.getStatus()!=Status.CANCELLED &&
                salarySlip.getStatus() !=Status.CANCELLED)
        {
            if (salarySlip.getVariablePay()!=salarySlip1.getVariablePay())
            {
                return salarySlipService.create(salarySlip);
            }
            else
            {
                return salarySlipDao.update(id,salarySlip);
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
