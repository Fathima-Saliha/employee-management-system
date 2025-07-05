package com.qis.FirstSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qis.FirstSpringBoot.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
		List<Employee> findByEmpName(String empName);

}
