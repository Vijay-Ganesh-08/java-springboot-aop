package org.training.sprinbootaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping(path="getEmployees",produces = {"application/json","application/xml"})
    public List<Employee> getAliens() {
        List<Employee> list =  employeeRepo.findAll();
        return list;
    }

    @GetMapping(path ="getEmployee", produces = {"application/json","application/xml"})
    public Employee getEmployees(@RequestParam int eid) {
        Employee employee = employeeRepo.findById(eid).orElse(new Employee(0,"",""));
        return employee;
    }

    @GetMapping(path="getEmployee/{eid}", produces = {"application/json","application/xml"})
    public Employee getEmployee(@PathVariable("eid") int eid) {
        return employeeRepo.findById(eid).orElse(new Employee(0,"",""));
    }

    @PostMapping(path = "addEmployee", consumes = {"application/json","application/xml"})
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

}
