package com.thielem.springwebflux.controller;

import com.thielem.springwebflux.model.Employee;
import com.thielem.springwebflux.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    //mono
    @GetMapping("/mono/{id}")
    private Mono<Employee> getEmployeeByIdWithMono(@PathVariable String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(UUID.fromString(id));
        Mono<Optional<Employee>> optionalMono = Mono.just(optionalEmployee);
        Mono<Employee> monoWithoutOptional = optionalMono.flatMap(Mono::justOrEmpty);

        return monoWithoutOptional;
    }

    //flux
    @GetMapping("/flux")
    private Flux<Object> getAllEmployeesWithFlux(){
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        Flux<Iterable<Employee>> iterableFlux = Flux.just(employeeIterable);
        Flux<Object> employeeFlux = iterableFlux.flatMap(Flux::just);

        return employeeFlux;
    }

}
