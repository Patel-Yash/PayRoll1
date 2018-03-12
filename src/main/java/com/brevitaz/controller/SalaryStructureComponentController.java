package com.brevitaz.controller;


import com.brevitaz.dao.SalaryStructureComponentDao;
import com.brevitaz.model.SalaryStructureComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salary-structure-components")
public class SalaryStructureComponentController {


    @Autowired
    private SalaryStructureComponentDao salaryStructureComponentDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalaryStructureComponent salaryStructureComponent)  {
        return salaryStructureComponentDao.create(salaryStructureComponent);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<SalaryStructureComponent> getAll(){
        return salaryStructureComponentDao.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody SalaryStructureComponent salaryStructureComponent, @PathVariable String id){
        return salaryStructureComponentDao.update(salaryStructureComponent,id);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) {
        return salaryStructureComponentDao.delete(id);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public SalaryStructureComponent getById(@PathVariable String id) {
        return salaryStructureComponentDao.getById(id);
    }
}
