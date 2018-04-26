package com.brevitaz.service.impl;

import com.brevitaz.dao.SalaryStructureDao;
import com.brevitaz.errors.InvalidIdException;
import com.brevitaz.model.SalaryStructure;
import com.brevitaz.model.Status;
import com.brevitaz.service.SalaryStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryStructureServiceImpl implements SalaryStructureService {

    @Autowired
    private SalaryStructureDao salaryStructureDao;

    @Override
    public boolean create(SalaryStructure salaryStructure)
    {
        salaryStructure.setStatus(Status.VALID);
        return salaryStructureDao.create(salaryStructure);

    }

    @Override
    public boolean delete(String id)
    {
        SalaryStructure salaryStructure = salaryStructureDao.getById(id);
        if (salaryStructure == null)
        {
            throw new InvalidIdException("Salary Structure doesn't exists!!!");
        }
        else
        {
            salaryStructure.setStatus(Status.CANCELLED);
            return salaryStructureDao.update(id,salaryStructure);
        }

    }

    @Override
    public boolean update(String id,SalaryStructure salaryStructure)
    {
        SalaryStructure salaryStructure1 = salaryStructureDao.getById(id);
        if (salaryStructure1.getStatus()!=Status.CANCELLED &&
                salaryStructure.getStatus() !=Status.CANCELLED)
        {
            return salaryStructureDao.update(id,salaryStructure);
        }
        else
        {
            throw new InvalidIdException("Update not done!!!");
        }
    }

    @Override
    public SalaryStructure getById(String id)
    {
        return salaryStructureDao.getById(id);
    }

    @Override
    public SalaryStructure getLatestSalaryStructure() {
        return salaryStructureDao.getLatestSalaryStructure();
    }

    @Override
    public List<SalaryStructure> getAll()
    {
        return salaryStructureDao.getAll();
    }
}
