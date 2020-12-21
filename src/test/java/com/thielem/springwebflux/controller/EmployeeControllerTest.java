package com.thielem.springwebflux.controller;

import com.thielem.springwebflux.model.Employee;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

public class EmployeeControllerTest {

    @Test
    public void getEmployeeByIdWithMono(){
        Employee employee = new Employee(UUID.fromString("29248586-f457-4384-ad9f-098d5f378967"), "Marcio Soares Thiele de Aguiar");
        Mono<Employee> employeeMono = Mono.just(employee);

        StepVerifier.create(employeeMono)
                    .expectNext(employee)
                    .verifyComplete();
    }
}
