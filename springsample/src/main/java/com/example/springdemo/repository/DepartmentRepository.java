package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
