package com.brevitaz.dao;

import com.brevitaz.model.SalaryIncomeComponent;
import com.brevitaz.model.SalaryStructure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        SalaryIncomeComponent salaryIncomeComponent = new SalaryIncomeComponent();
        salaryIncomeComponent.setId("11");
        salaryIncomeComponent.setDisplayName("Basic");
        salaryIncomeComponent.setName("Basic@12%");
        salaryIncomeComponent.setValue(12);

        List<SalaryIncomeComponent> salaryIncomeComponents = new ArrayList<>();
        salaryIncomeComponents.add(salaryIncomeComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryIncomeComponents(salaryIncomeComponents);
        salaryStructureDao.create(salaryStructure);

        SalaryStructure salaryStructure1 = salaryStructureDao.getById("11");
        Assert.assertEquals(salaryStructure1.getSalaryIncomeComponents(),salaryStructure.getSalaryIncomeComponents());

        salaryStructureDao.delete("11");
    }

    @Test
    public void getAllTest()  {
        SalaryIncomeComponent salaryIncomeComponent = new SalaryIncomeComponent();
        salaryIncomeComponent.setId("11");
        salaryIncomeComponent.setDisplayName("Basic");
        salaryIncomeComponent.setName("Basic@12%");
        salaryIncomeComponent.setValue(12);

        List<SalaryIncomeComponent> salaryIncomeComponents = new ArrayList<>();
        salaryIncomeComponents.add(salaryIncomeComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryIncomeComponents(salaryIncomeComponents);
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

        SalaryIncomeComponent salaryIncomeComponent = new SalaryIncomeComponent();
        salaryIncomeComponent.setId("11");
        salaryIncomeComponent.setDisplayName("Basic");
        salaryIncomeComponent.setName("Basic@12%");
        salaryIncomeComponent.setValue(12);

        List<SalaryIncomeComponent> salaryIncomeComponents = new ArrayList<>();
        salaryIncomeComponents.add(salaryIncomeComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryIncomeComponents(salaryIncomeComponents);
        salaryStructureDao.create(salaryStructure);


        SalaryIncomeComponent salaryIncomeComponent1 = new SalaryIncomeComponent();
        salaryIncomeComponent1.setId("11");
        salaryIncomeComponent1.setDisplayName("HRA");
        salaryIncomeComponent1.setName("HRA@20%");
        salaryIncomeComponent1.setValue(20);

        List<SalaryIncomeComponent> salaryIncomeComponents1 = new ArrayList<>();
        salaryIncomeComponents1.add(salaryIncomeComponent1);

        SalaryStructure salaryStructure1 = new SalaryStructure();
        salaryStructure1.setSalaryIncomeComponents(salaryIncomeComponents1);

        salaryStructureDao.update(salaryStructure1,"11");

        SalaryStructure salaryStructure2 = salaryStructureDao.getById("11");
        Assert.assertEquals(salaryStructure2.getSalaryIncomeComponents(),salaryStructure1.getSalaryIncomeComponents());

        salaryStructureDao.delete("11");
    }

    @Test
    public void deleteTest() {

        SalaryIncomeComponent salaryIncomeComponent = new SalaryIncomeComponent();
        salaryIncomeComponent.setId("11");
        salaryIncomeComponent.setDisplayName("Basic");
        salaryIncomeComponent.setName("Basic@12%");
        salaryIncomeComponent.setValue(12);

        List<SalaryIncomeComponent> salaryIncomeComponents = new ArrayList<>();
        salaryIncomeComponents.add(salaryIncomeComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryIncomeComponents(salaryIncomeComponents);
        salaryStructureDao.create(salaryStructure);

        salaryStructureDao.delete("11");

        SalaryStructure salaryStructure1 = salaryStructureDao.getById("11");
        Assert.assertNull(salaryStructure1);


    }

    @Test
    public void getByIdTest() {

        SalaryIncomeComponent salaryIncomeComponent = new SalaryIncomeComponent();
        salaryIncomeComponent.setId("11");
        salaryIncomeComponent.setDisplayName("Basic");
        salaryIncomeComponent.setName("Basic@12%");
        salaryIncomeComponent.setValue(12);

        List<SalaryIncomeComponent> salaryIncomeComponents = new ArrayList<>();
        salaryIncomeComponents.add(salaryIncomeComponent);

        SalaryStructure salaryStructure = new SalaryStructure();
        salaryStructure.setId("11");
        salaryStructure.setSalaryIncomeComponents(salaryIncomeComponents);
        salaryStructureDao.create(salaryStructure);

        SalaryStructure salaryStructure1 = salaryStructureDao.getById("11");
        Assert.assertEquals(salaryStructure1.getSalaryIncomeComponents(),salaryStructure.getSalaryIncomeComponents());

        salaryStructureDao.delete("11");
    }

}
