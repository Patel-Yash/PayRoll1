package com.brevitaz.controller;

import com.brevitaz.dao.SalarySlipDao;
import com.brevitaz.model.SalarySlip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary-slips")
public class SalarySlipController
{

    @Autowired
    private SalarySlipDao salarySlipDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalarySlip salarySlip) {
        return salarySlipDao.create(salarySlip);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SalarySlip> getAll() {
        return salarySlipDao.getAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody SalarySlip salarySlip, @PathVariable String id)  {
        return salarySlipDao.update(salarySlip,id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) {
        return salarySlipDao.delete(id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public SalarySlip getById(@PathVariable String id) {
        return salarySlipDao.getById(id);

    }
}
