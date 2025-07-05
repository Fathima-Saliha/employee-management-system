package com.qis.FirstSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qis.FirstSpringBoot.entity.Employee;
import com.qis.FirstSpringBoot.sevice.EmpService;
import com.qis.FirstSpringBoot.utils.ResponseStructure;



@RestController
@RequestMapping("/api/employee")
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	/* ───────── CREATE ───────── */
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee emp) {
		ResponseStructure<Employee> save = service.save(emp);
		return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.CREATED).ok(save);
	}
	
	/* ───────── READ ONE ───────── */
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeBasedOnId(@PathVariable int id) {
		ResponseStructure<Employee> employee=service.getEmployee(id);
		return ResponseEntity.ok(employee);
	}
	
	 /* ───────── READ ALL ───────── */
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Employee>>>getAllEmployee() {
		ResponseStructure<List<Employee>> emp=service.getAllEmployee();
		return ResponseEntity.ok(emp);
		
	}
	
	  /* ───────── DELETE ───────── */
	
//	@DeleteMapping("/delete/{id}")
//	public String deleteEmployeeBasedOnId(@PathVariable int id) {
//		String del = service.deleteEmployee(id);
//		return del;
//	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeBasedOnId(@PathVariable int id) {
		ResponseStructure<String> del = service.deleteEmployee(id);
		return ResponseEntity.ok(del);
	}
	
	/* ───────── UPDATE ─────────*/
	
//	@PutMapping("/update/{id}")
//	public Employee updateEmployee(@RequestBody Employee emp) {
//		Employee employee = service.updateEmployee(emp);
//		return employee;
//	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee emp) {
		ResponseStructure<Employee> employee = service.updateEmployee(emp);
		return ResponseEntity.ok(employee);
	}
	
	/* ───────── SEARCH BY NAME ───────── */
	@GetMapping("/byname/{name}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmpName(@PathVariable String name){
		ResponseStructure<List<Employee>> list =service.getEmpByName(name);
		return ResponseEntity.ok(list);
	}
	

    /* ───────── MAX SALARY ───────── */
	@GetMapping("/max-sal")
    public ResponseEntity<ResponseStructure<Employee>> getEmpByMaxSal() {
       ResponseStructure<Employee> e= service.getEmpByMaxSal();
       return ResponseEntity.ok(e);
    }
	
}

//api through flow cheyyne json format(backendn data vernd) key value pair
//patch-partial update , put-update