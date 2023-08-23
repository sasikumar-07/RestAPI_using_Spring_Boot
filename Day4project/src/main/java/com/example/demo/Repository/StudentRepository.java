package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>
{

}
