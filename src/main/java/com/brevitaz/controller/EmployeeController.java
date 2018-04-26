package com.brevitaz.controller;


import com.brevitaz.model.Employee;
import com.brevitaz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Employee employee) {
        return employeeService.create(employee);

    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAll(){
         return employeeService.getAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update( @PathVariable String id,@RequestBody Employee employee) {
        return employeeService.update(id,employee);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) {
        return employeeService.delete(id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Employee getById(@PathVariable String id) {
         return employeeService.getById(id);

    }
}