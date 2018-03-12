package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import com.brevitaz.model.Salary;
import com.brevitaz.model.SalarySlip;
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
public class SalarySlipDaoTest
{
    @Autowired
    SalarySlipDao salarySlipDao;

    @Test
    public void createTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("1");

        Employee employee1 = new Employee();
        employee1.setId("AA");
        employee1.setName("Yash");

        salarySlip.setEmployee(employee1);
        salarySlip.setVariablePay(60000);
        salarySlipDao.create(salarySlip);

        SalarySlip salarySlip1 = salarySlipDao.getById("1");
        Assert.assertEquals(salarySlip1.getEmployee().getName(),salarySlip.getEmployee().getName());
        salarySlipDao.delete("1");
    }

    @Test
    public void getAllTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("2");
        Employee employee1 = new Employee();
        employee1.setId("AA");
        employee1.setName("Yash");

        salarySlip.setEmployee(employee1);
        salarySlip.setVariablePay(30000);
        salarySlipDao.create(salarySlip);

        SalarySlip salarySlip1 = new SalarySlip();
        salarySlip1.setId("1");
        Employee employee2 = new Employee();
        employee1.setId("BB");
        employee1.setName("Arpy");

        salarySlip.setEmployee(employee2);
        salarySlip1.setVariablePay(30000);
        salarySlipDao.create(salarySlip1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<SalarySlip> salarySlips = salarySlipDao.getAll();
        int size = salarySlips.size();
        Assert.assertEquals(2,size);
       salarySlipDao.delete("1");
       salarySlipDao.delete("2");
    }

    @Test
    public void updateTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("3");
        Employee employee1 = new Employee();
        employee1.setId("AA");
        employee1.setName("Yash");

        salarySlip.setEmployee(employee1);
        salarySlip.setVariablePay(60000);
        salarySlipDao.create(salarySlip);

        SalarySlip salarySlip1 = new SalarySlip();
        Employee employee2 = new Employee();
        employee2.setId("AA");
        employee2.setName("Arpy");

        salarySlip.setEmployee(employee2);
        salarySlip1.setVariablePay(200);
        salarySlipDao.update(salarySlip1,"3");

        SalarySlip salarySlip2 = salarySlipDao.getById("3");

        Assert.assertEquals(salarySlip2.getEmployee().getName(),salarySlip1.getEmployee().getName());

        salarySlipDao.delete("3");
    }

    @Test
    public void deleteTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("4");
        Employee employee1 = new Employee();
        employee1.setId("AA");
        employee1.setName("Yash");

        salarySlip.setEmployee(employee1);
        salarySlip.setVariablePay(60000);
        salarySlipDao.create(salarySlip);

        salarySlipDao.delete("4");
        SalarySlip salarySlip1 = salarySlipDao.getById("4");

        Assert.assertNull(salarySlip1);


    }

    @Test
    public void getByIdTest() throws IOException {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setId("5");
        Employee employee1 = new Employee();
        employee1.setId("AA");
        employee1.setName("Yash");

        salarySlip.setEmployee(employee1);
        salarySlip.setVariablePay(6000);
        salarySlipDao.create(salarySlip);

        SalarySlip salarySlip1 = salarySlipDao.getById("5");

        Assert.assertEquals(salarySlip1.getEmployee().getName(),salarySlip.getEmployee().getName());

        salarySlipDao.delete("5");
    }

}
