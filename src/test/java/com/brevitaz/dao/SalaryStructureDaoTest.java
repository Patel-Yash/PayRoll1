package com.brevitaz.dao;

import com.brevitaz.model.SalaryStructure;
import com.brevitaz.model.SalaryStructureComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalaryStructureDaoTest
{
    @Autowired
    SalaryStructureDao salaryStructureDao;

    @Test
    public void createTest() {
        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryStructureComponents(salaryStructureComponents);
        salaryStructureDao.create(salaryStructure);

        SalaryStructure salaryStructure1 = salaryStructureDao.getById("11");
        Assert.assertEquals(salaryStructure1.getSalaryStructureComponents(),salaryStructure.getSalaryStructureComponents());

        salaryStructureDao.delete("11");
    }

    @Test
    public void getAllTest()  {
        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryStructureComponents(salaryStructureComponents);
        salaryStructureDao.create(salaryStructure);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<SalaryStructure> salaryStructures = salaryStructureDao.getAll();
        int size = salaryStructures.size();
        Assert.assertEquals(1,size);

        salaryStructureDao.delete("11");
    }

    @Test
    public void updateTest()  {

        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryStructureComponents(salaryStructureComponents);
        salaryStructureDao.create(salaryStructure);


        SalaryStructureComponent salaryStructureComponent1 = new SalaryStructureComponent();
        salaryStructureComponent1.setId("11");
        salaryStructureComponent1.setDisplayName("HRA");
        salaryStructureComponent1.setName("HRA@20%");
        salaryStructureComponent1.setValue(20);

        List<SalaryStructureComponent>salaryStructureComponents1 = new ArrayList<>();
        salaryStructureComponents1.add(salaryStructureComponent1);

        SalaryStructure salaryStructure1 = new SalaryStructure();
        salaryStructure1.setSalaryStructureComponents(salaryStructureComponents1);

        salaryStructureDao.update(salaryStructure1,"11");

        SalaryStructure salaryStructure2 = salaryStructureDao.getById("11");
        Assert.assertEquals(salaryStructure2.getSalaryStructureComponents(),salaryStructure1.getSalaryStructureComponents());

        salaryStructureDao.delete("11");
    }

    @Test
    public void deleteTest() {

        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryStructureComponents(salaryStructureComponents);
        salaryStructureDao.create(salaryStructure);

        salaryStructureDao.delete("11");

        SalaryStructure salaryStructure1 = salaryStructureDao.getById("11");
        Assert.assertNull(salaryStructure1);


    }

    @Test
    public void getByIdTest() {

        SalaryStructureComponent salaryStructureComponent = new SalaryStructureComponent();
        salaryStructureComponent.setId("11");
        salaryStructureComponent.setDisplayName("Basic");
        salaryStructureComponent.setName("Basic@12%");
        salaryStructureComponent.setValue(12);

        List<SalaryStructureComponent>salaryStructureComponents = new ArrayList<>();
        salaryStructureComponents.add(salaryStructureComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryStructureComponents(salaryStructureComponents);
        salaryStructureDao.create(salaryStructure);

        SalaryStructure salaryStructure1 = salaryStructureDao.getById("11");
        Assert.assertEquals(salaryStructure1.getSalaryStructureComponents(),salaryStructure.getSalaryStructureComponents());

        salaryStructureDao.delete("11");
    }

}
