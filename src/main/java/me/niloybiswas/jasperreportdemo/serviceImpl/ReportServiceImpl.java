package me.niloybiswas.jasperreportdemo.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.niloybiswas.jasperreportdemo.entity.Employee;
import me.niloybiswas.jasperreportdemo.repository.EmployeeRepo;
import me.niloybiswas.jasperreportdemo.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException  {
        List<Employee> employees = employeeRepo.findAll();
        final String path = "reports";
        
        // load file and compile
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Niloy");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + File.separator + "employees.pdf");
        } else {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + File.separator + "employee.html");
        }

        return "report generated at " + path + File.separator;
    }
    
}
