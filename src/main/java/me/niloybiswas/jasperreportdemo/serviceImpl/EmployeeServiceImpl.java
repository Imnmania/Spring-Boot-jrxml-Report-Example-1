package me.niloybiswas.jasperreportdemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import me.niloybiswas.jasperreportdemo.entity.Employee;
import me.niloybiswas.jasperreportdemo.repository.EmployeeRepo;
import me.niloybiswas.jasperreportdemo.service.EmployeeService;

@Data
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private final EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    
}
