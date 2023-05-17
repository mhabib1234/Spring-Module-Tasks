package com.academy.Bjit.repository;

import java.util.List;
import java.util.Optional;

import com.academy.Bjit.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmpcity(String emp_city);


}
