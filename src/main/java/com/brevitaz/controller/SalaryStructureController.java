package com.brevitaz.controller;

import com.brevitaz.model.SalaryStructure;
import com.brevitaz.service.SalaryStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/salary-structures")
public class SalaryStructureController {

    @Autowired
    private SalaryStructureService salaryStructureService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean create(@Valid @RequestBody SalaryStructure salaryStructure)  {
        return salaryStructureService.create(salaryStructure);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SalaryStructure getById( @PathVariable String id) {
        return salaryStructureService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable String id,@RequestBody SalaryStructure salaryStructure) {
        return salaryStructureService.update(id,salaryStructure);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) {
        return salaryStructureService.delete(id);

    }

    @RequestMapping(value = "latest-structure",method = {RequestMethod.GET})
    public SalaryStructure getLatestSalaryStructure()
    {
        return salaryStructureService.getLatestSalaryStructure();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SalaryStructure> getAll() {
        return salaryStructureService.getAll();

    }



}
