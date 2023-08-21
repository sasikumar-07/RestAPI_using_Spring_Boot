package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EmployeeEntity;
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
