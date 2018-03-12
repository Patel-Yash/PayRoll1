package com.brevitaz.dao;


import com.brevitaz.model.Employee;
import com.brevitaz.model.Salary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalaryDaoTest
{
    @Autowired
    SalaryDao salaryDao;

    @Test
    public void createTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("1");
        salary.setEmployeeId("1");
        salary.setSalaryStructureId("1");
        salary.setGrossSalary(1200000);
        salary.setVariablePay(60000);
        salary.setOtherAllowance(20000);

        Salary salary1 = salaryDao.getById("1");
        Assert.assertEquals(salary1.getEmployeeId(),salary.getEmployeeId());
        salaryDao.delete("1");
    }

    @Test
    public void getAllTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("1");
        salary.setEmployeeId("AA");
        salary.setSalaryStructureId("1");
        salary.setGrossSalary(120000);
        salary.setVariablePay(6000);
        salary.setOtherAllowance(2000);
        salaryDao.create(salary);

        Salary salary1 = new Salary();
        salary.setId("2");
        salary.setEmployeeId("BB");
        salary.setSalaryStructureId("2");
        salary.setGrossSalary(12000);
        salary.setVariablePay(600);
        salary.setOtherAllowance(200);
        salaryDao.create(salary1);

        List<Salary> salaries = salaryDao.getAll();
        Assert.assertEquals(2,salaries);
        salaryDao.delete("1");
        salaryDao.delete("2");
    }

    @Test
    public void updateTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("3");
        salary.setEmployeeId("3");
        salary.setSalaryStructureId("3");
        salary.setGrossSalary(600000);
        salary.setVariablePay(30000);
        salary.setOtherAllowance(100000);
        salaryDao.create(salary);

        Salary salary1 = new Salary();
        salary1.setEmployeeId("4");
        salary1.setOtherAllowance(200);
        salaryDao.update(salary1,"3");

        Salary salary2 = salaryDao.getById("3");

        Assert.assertEquals(salary2.getEmployeeId(),salary1.getEmployeeId());

      salaryDao.delete("3");



    }

    @Test
    public void deleteTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("4");
        salary.setEmployeeId("4");
        salary.setSalaryStructureId("4");
        salary.setGrossSalary(1200000);
        salary.setVariablePay(60000);
        salary.setOtherAllowance(20000);
        salaryDao.create(salary);

        salaryDao.delete("4");

        Salary salary1 = salaryDao.getById("4");

        Assert.assertNull(salary1);
    }

    @Test
    public void getByIdTest() throws IOException {
        Salary salary = new Salary();
        salary.setId("5");
        salary.setEmployeeId("5");
        salary.setSalaryStructureId("5");
        salary.setGrossSalary(300000);
        salary.setVariablePay(20000);
        salary.setOtherAllowance(3000);

        boolean status = salaryDao.create(salary);
        Assert.assertEquals(true,status);

        Salary salary1 = salaryDao.getById("5");
        Assert.assertNotNull(salary1);
    }

}
