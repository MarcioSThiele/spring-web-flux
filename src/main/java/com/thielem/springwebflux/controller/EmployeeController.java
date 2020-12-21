package com.thielem.springwebflux.controller;

import com.thielem.springwebflux.model.Employee;
import com.thielem.springwebflux.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<Iterable<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeRepository.findById(UUID.fromString(id)));
    }

}
