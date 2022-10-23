package me.niloybiswas.jasperreportdemo.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.niloybiswas.jasperreportdemo.entity.Employee;
import me.niloybiswas.jasperreportdemo.service.EmployeeService;
import me.niloybiswas.jasperreportdemo.service.ReportService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    private final ReportService reportService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, OK);
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws Exception {
        return reportService.exportReport(format);
    }

}
