package com.brevitaz.controller;


import com.brevitaz.model.Salary;
import com.brevitaz.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Salary salary) // give salary a ssid
    {
        return salaryService.create(salary);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Salary> getAll() {
        return salaryService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable String id,@RequestBody Salary salary) {
        return salaryService.update(id,salary);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id)  {
        return salaryService.delete(id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Salary getById(@PathVariable String id) {
       return salaryService.getById(id);

    }

    @RequestMapping(value = "employee-id/{employeeId}", method = {RequestMethod.GET})
    public List<Salary> getByEmployeeId(@PathVariable String employeeId) {
        return salaryService.getByEmployeeId(employeeId);

    }

    @RequestMapping(value = "{employeeId}/current-salary", method = {RequestMethod.GET})
    public Salary getLatestSalary(@PathVariable String employeeId) {
        return salaryService.getLatestSalary(employeeId);

    }


}
