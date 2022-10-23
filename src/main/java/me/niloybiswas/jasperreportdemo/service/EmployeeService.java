package me.niloybiswas.jasperreportdemo.service;

import java.util.List;

import me.niloybiswas.jasperreportdemo.entity.Employee;

public interface EmployeeService {
    
    List<Employee> getEmployees();

    Employee createEmployee(Employee employee);

}
