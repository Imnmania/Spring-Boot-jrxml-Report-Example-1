package me.niloybiswas.jasperreportdemo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.niloybiswas.jasperreportdemo.entity.Employee;
import me.niloybiswas.jasperreportdemo.service.EmployeeService;

@SpringBootApplication
public class JasperReportDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasperReportDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(EmployeeService employeeService) {
		return args -> {
			employeeService.createEmployee(new Employee(null, "Emp A", new Date(), 10000L));
			employeeService.createEmployee(new Employee(null, "Emp B", new Date(), 11000L));
			employeeService.createEmployee(new Employee(null, "Emp C", new Date(), 12000L));
			employeeService.createEmployee(new Employee(null, "Emp E", new Date(), 13000L));
			employeeService.createEmployee(new Employee(null, "Emp F", new Date(), 14000L));
			employeeService.createEmployee(new Employee(null, "Emp G", new Date(), 15000L));
			employeeService.createEmployee(new Employee(null, "Emp H", new Date(), 16000L));
		};
	}

}
