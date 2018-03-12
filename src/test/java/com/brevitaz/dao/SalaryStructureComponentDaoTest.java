package com.brevitaz.dao;

import com.brevitaz.model.SalaryStructureComponent;
import com.brevitaz.model.Type;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalaryStructureComponentDaoTest
{
    @Autowired
    SalaryStructureComponentDao salaryStructureComponentDao;

    @Test
    public void createTest()  {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);
        salaryStructureComponentDao.create(salaryStructureComponent);

        SalaryStructureComponent salaryStructureComponent1 = salaryStructureComponentDao.getById("11");
        Assert.assertEquals(salaryStructureComponent1.getName(),salaryStructureComponent.getName());

        salaryStructureComponentDao.delete("11");
    }

    @Test
    public void getAllTest() {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);
        salaryStructureComponentDao.create(salaryStructureComponent);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<SalaryStructureComponent> salaryStructureComponents = salaryStructureComponentDao.getAll();
        int size = salaryStructureComponents.size();
        Assert.assertEquals(1,size);

        salaryStructureComponentDao.delete("11");
    }

    @Test
    public void updateTest()  {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);
        salaryStructureComponentDao.create(salaryStructureComponent);

        SalaryStructureComponent salaryStructureComponent1 = new SalaryStructureComponent();
        salaryStructureComponent1.setName("Basics");
        salaryStructureComponentDao.update(salaryStructureComponent1,"11");

        SalaryStructureComponent salaryStructureComponent2 =salaryStructureComponentDao.getById("11");
        Assert.assertEquals(salaryStructureComponent2.getName(),salaryStructureComponent1.getName());

        salaryStructureComponentDao.delete("11");
    }

    @Test
    public void deleteTest()  {
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);
        salaryStructureComponentDao.create(salaryStructureComponent);

        salaryStructureComponentDao.delete("11");

        SalaryStructureComponent salaryStructureComponent1 = salaryStructureComponentDao.getById("11");
        Assert.assertNull(salaryStructureComponent1);

    }

    @Test
    public void getByIdTest(){
        SalaryStructureComponent salaryStructureComponent= new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);
        salaryStructureComponentDao.create(salaryStructureComponent);

        SalaryStructureComponent salaryStructureComponent1 = salaryStructureComponentDao.getById("11");
        Assert.assertEquals(salaryStructureComponent1.getName(),salaryStructureComponent.getName());

        salaryStructureComponentDao.delete("11");
    }

}
