package com.brevitaz.controller;

import com.brevitaz.model.SalarySlip;
import com.brevitaz.service.SalarySlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary-slips")
public class SalarySlipController
{

    @Autowired
    private SalarySlipService salarySlipService;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalarySlip salarySlip) {
        return salarySlipService.create(salarySlip);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SalarySlip> getAll() {
        return salarySlipService.getAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable String id,@RequestBody SalarySlip salarySlip)  {
        return salarySlipService.update(id,salarySlip);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) {
        return salarySlipService.delete(id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public SalarySlip getById(@PathVariable String id) {
        return salarySlipService.getById(id);

    }

    @RequestMapping(value = "month/{month}", method = {RequestMethod.GET})
    public List<SalarySlip> getByMonth(@PathVariable String month)
    {
        return salarySlipService.getByMonth(month);
    }

    @RequestMapping(value = "employee-id/{employeeId}", method = {RequestMethod.GET})
    public List<SalarySlip> getByEmployeeId(@PathVariable String employeeId)
    {
        return salarySlipService.getByEmployeeId(employeeId);
    }

    @RequestMapping(value = "employee-id/{employeeId}/current-salary-slip", method = {RequestMethod.GET})
    public SalarySlip getLatestSalarySlip(@PathVariable String employeeId)
    {
        return salarySlipService.getLatestSalarySlip(employeeId);
    }
}
