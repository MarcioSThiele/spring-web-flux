package com.thielem.springwebflux.controller;

import com.thielem.springwebflux.model.Employee;
import com.thielem.springwebflux.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    private String getHelloCompany(){
        return "Hello Company";
    }

    @GetMapping("/{id}")
    private Optional<Employee> getEmployeeById(@PathVariable String id) {
        return employeeRepository.findById(UUID.fromString(id));
    }
}
