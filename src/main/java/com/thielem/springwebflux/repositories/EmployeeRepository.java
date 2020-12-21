package com.thielem.springwebflux.repositories;

import com.thielem.springwebflux.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {

}
