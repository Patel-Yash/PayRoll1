package com.brevitaz.controller;


import com.brevitaz.dao.SalaryDao;
import com.brevitaz.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    private SalaryDao salaryDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Salary salary) // give salary a ssid
    {
        return salaryDao.create(salary);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Salary> getAll() {
        return salaryDao.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody Salary salary, @PathVariable String id) {
        return salaryDao.update(salary,id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id)  {
        return salaryDao.delete(id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Salary getById(@PathVariable String id) {
       return salaryDao.getById(id);

    }
}
