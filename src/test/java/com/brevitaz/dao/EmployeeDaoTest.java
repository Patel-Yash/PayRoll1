package com.brevitaz.dao;

import com.brevitaz.model.Employee;
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
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void createTest() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        Employee employee1 = employeeDao.getById("11");
        Assert.assertEquals(employee1.getName(),employee.getName());
        employeeDao.delete("11");
    }

    @Test
    public void getAllTest() {
        Employee employee1 = new Employee();
        employee1.setId("11");
        employee1.setName("Yash");
        employee1.setDepartment("Java");
        employeeDao.create(employee1);

        Employee employee2 = new Employee();
        employee1.setId("12");
        employee1.setName("Yash");
        employee1.setDepartment("Java");
        employeeDao.create(employee1);

        Employee employee3 = new Employee();
        employee1.setId("13");
        employee1.setName("Yash");
        employee1.setDepartment("Java");
        employeeDao.create(employee1);

        List<Employee> employees = employeeDao.getAll();
        Assert.assertEquals(3,employees);
        employeeDao.delete("11");
        employeeDao.delete("12");
        employeeDao.delete("13");
    }

    @Test
    public void getByIdTest() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        Employee employee1 = employeeDao.getById("11");
        Assert.assertEquals(employee1.getName(),employee.getName());
        employeeDao.delete("11");
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        Employee employee1 = new Employee();
        employee1.setName("Arpy");
        employeeDao.update(employee1,"11");

        Employee employee3 = employeeDao.getById("11");
        Assert.assertEquals(employee3.getName(),employee1.getName());
        employeeDao.delete("11");

    }

    @Test
    public void delete() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        employeeDao.delete("11");
        Employee employee1 = employeeDao.getById("11");

        Assert.assertNull(employee1);


    }
}
