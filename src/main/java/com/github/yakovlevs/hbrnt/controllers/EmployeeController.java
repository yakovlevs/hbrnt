package com.github.yakovlevs.hbrnt.controllers;

import com.github.yakovlevs.hbrnt.persistent.domain.Employee;
import com.github.yakovlevs.hbrnt.persistent.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/empl")
public class EmployeeController {
  @Autowired
  private EmployeeRepository _employeeRepository;

  @RequestMapping(value = "/range")
  @ResponseBody
  public List<Employee> getRange(int first, int max) {
    List<Employee> employees = null;
    try {
      employees = _employeeRepository.getRangeOfEmployees(first, max);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return employees;
  }

  @RequestMapping(value = "/{id}")
  @ResponseBody
  public Employee getById(@PathVariable("id") Long id) {
    Employee employee = null;
    try {
      employee = _employeeRepository.getById(id);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return employee;
  }

  @RequestMapping(value = "/page")
  @ResponseBody
  public List<Employee> getPage(int pageNumber, int pageSize) {
    return _employeeRepository.getRangeOfEmployees((pageNumber - 1) * pageSize, pageSize);
  }
}
