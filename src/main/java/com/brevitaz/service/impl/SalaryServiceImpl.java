package com.brevitaz.service.impl;

import com.brevitaz.dao.SalaryDao;
import com.brevitaz.errors.InvalidIdException;
import com.brevitaz.model.*;
import com.brevitaz.service.SalaryService;
import com.brevitaz.service.SalaryStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private SalaryStructureService salaryStructureService;

    @Override
    public boolean create(Salary salary)
    {
        SalaryStructure salaryStructure =salaryStructureService.getLatestSalaryStructure();
        salary.setSalaryStructureId(salaryStructure.getId());
        List<SalaryIncomeComponent> salaryIncomeComponents =salaryStructure.getSalaryIncomeComponents();
        List<SalaryDeductionComponent> salaryDeductionComponents=salaryStructure.getSalaryDeductionComponents();

        List<SalaryIncomeComponent> salaryIncomeComponentList = new ArrayList<>();
        List<SalaryDeductionComponent> salaryDeductionComponentList = new ArrayList<>();
        for (SalaryIncomeComponent salaryIncomeComponent:salaryIncomeComponents)
        {
            if (salaryIncomeComponent.getType()==Type.PERCENTAGE)
            {
                salaryIncomeComponent.setAmount((salary.getGrossSalary()*salaryIncomeComponent.getValue())/100);
                System.out.println(salaryIncomeComponent.getDisplayName()+" "+salaryIncomeComponent.getAmount());
            }
            if (salaryIncomeComponent.getType()==Type.FIXED_VALUE)
            {
                salaryIncomeComponent.setAmount(salaryIncomeComponent.getValue());
                System.out.println(salaryIncomeComponent.getDisplayName()+" "+salaryIncomeComponent.getAmount());

            }
             salaryIncomeComponentList.add(salaryIncomeComponent);
        }
        for (SalaryDeductionComponent salaryDeductionComponent:salaryDeductionComponents)
        {
            if (salaryDeductionComponent.getType()==Type.PERCENTAGE)
            {
                salaryDeductionComponent.setAmount ((salary.getGrossSalary()*salaryDeductionComponent.getValue())/100);
            }
            if (salaryDeductionComponent.getType()==Type.FIXED_VALUE)
            {
                salaryDeductionComponent.setAmount(salaryDeductionComponent.getValue());
            }
            salaryDeductionComponentList.add(salaryDeductionComponent);
        }
        salary.setSalaryIncomeComponents(salaryIncomeComponentList);
        salary.setSalaryDeductionComponents(salaryDeductionComponentList);

        double totalAmount = 0;

        for (SalaryIncomeComponent salaryIncomeComponent:salaryIncomeComponentList)
        {
            totalAmount+=salaryIncomeComponent.getAmount();
        }
        System.out.println(totalAmount);
        salary.setOtherAllowance(salary.getGrossSalary()-(totalAmount+salary.getVariablePay()));

        salary.setStatus(Status.VALID);
        return salaryDao.create(salary);
    }

    @Override
    public boolean delete(String id)
    {
        Salary salary = salaryDao.getById(id);
        if (salary == null)
        {
            throw new InvalidIdException("Salary doesn't exists!!!");
        }
        else
        {
            salary.setStatus(Status.CANCELLED);
            return salaryDao.update(id,salary);
        }

    }

    @Override
    public boolean update(String id,Salary salary )
    {
        Salary salary1 = salaryDao.getById(id);
        if (salary1.getStatus()!=Status.CANCELLED &&
                salary.getStatus() !=Status.CANCELLED)
        {
            if (salary.getVariablePay()!=salary1.getVariablePay())
            {
                return salaryDao.update(id,salary);
            }
           else
            {
                return salaryService.create(salary);
            }
        }
        else
        {
            throw new InvalidIdException("Update not done!!!");
        }
    }

    @Override
    public Salary getById(String id)
    {
        return salaryDao.getById(id);
    }

    @Override
    public List<Salary> getAll()
    {
        return salaryDao.getAll();
    }

    @Override
    public Salary getLatestSalary(String employeeId)
    {
        List<Salary> salaries = salaryService.getByEmployeeId(employeeId);
        return salaryDao.getLatestSalary(salaries);
    }

    @Override
    public List<Salary> getByEmployeeId(String employeeId)
    {
        return salaryDao.getByEmployeeId(employeeId);
    }
}
