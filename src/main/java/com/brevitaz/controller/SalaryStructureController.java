package com.brevitaz.controller;

import com.brevitaz.dao.SalaryStructureDao;
import com.brevitaz.model.SalaryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary-structures")
public class SalaryStructureController {

    @Autowired
    private SalaryStructureDao salaryStructureDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalaryStructure salaryStructure)  {
        return salaryStructureDao.create(salaryStructure);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SalaryStructure getById( @PathVariable String id) {
        return salaryStructureDao.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody SalaryStructure salaryStructure, @PathVariable String id) {
        return salaryStructureDao.update(salaryStructure,id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) {
        return salaryStructureDao.delete(id);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SalaryStructure> getAll() {
        return salaryStructureDao.getAll();

    }



}
