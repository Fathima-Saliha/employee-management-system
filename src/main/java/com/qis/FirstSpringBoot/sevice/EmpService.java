package com.qis.FirstSpringBoot.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.qis.FirstSpringBoot.entity.Employee;
import com.qis.FirstSpringBoot.exception.EmployeeNotFoundException;
import com.qis.FirstSpringBoot.repository.EmpRepo;
import com.qis.FirstSpringBoot.utils.ErrorStructure;
import com.qis.FirstSpringBoot.utils.ResponseStructure;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	/* ---------- CREATE ---------- */
	public ResponseStructure<Employee> save(Employee emp) {
		Employee save=repo.save(emp);
		ResponseStructure<Employee> r = new ResponseStructure<Employee>();
		r.setStatus(HttpStatus.CREATED.value());
		r.setMessage("Inserted Succesfully");
		r.setData(save);
		return r;
	}
	
	 /* ---------- READ ONE ---------- */
	public ResponseStructure<Employee> getEmployee(int id) {
		Employee byId = repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("employee with id " +id+ " doesnt exist"));
		ResponseStructure<Employee> r = new ResponseStructure<Employee>();
		r.setStatus(HttpStatus.OK.value());
		r.setMessage("Employee Found");
		r.setData(byId);
		return r;
	}
	
	
	/* ---------- READ ALL ---------- */
	public ResponseStructure<List<Employee>> getAllEmployee() {
		List<Employee> all = repo.findAll();
		ResponseStructure<List<Employee>> r= new ResponseStructure<>();
		r.setStatus(HttpStatus.OK.value());
		r.setMessage(all.isEmpty() ? "No employees found" : "Employees list fetched");
		r.setData(all);
		return r;
		
	}
	
	/* ---------- DELETE ---------- */
	
//	public String deleteEmployee(int id) {
//		repo.deleteById(id);
//		return "deleted";	
//	}
	
	
	public ResponseStructure<String> deleteEmployee(int id) {
		Employee byId = repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Cannot delete. Employee with id " + id + " doesn't exist"));
		repo.delete(byId);	
		
		ResponseStructure<String> r = new ResponseStructure<String>();
		r.setStatus(HttpStatus.OK.value());
		r.setMessage("Deleted Succesfully");
		r.setData("Employee with id " + id + " has been deleted");
		return r;
	}
	
	/* ---------- UPDATE ---------- */
	
//	public Employee updateEmployee(Employee emp) {
//		Optional<Employee> id = repo.findById(emp.getEmpId()); //after jdk8 ,nullpointer exception remove cheyyan illa class,kore methods nd to check
//		Employee employee = id.get();
//		employee.setEmpName(emp.getEmpName());
//		employee.setEmpSal(emp.getEmpSal());
//		employee.setEmpDesignation(emp.getEmpDesignation());
//		Employee save = repo.save(employee);
//		return save;
//	}
	
	public ResponseStructure<Employee> updateEmployee(Employee emp) {
		Employee id = repo.findById(emp.getEmpId())
				.orElseThrow(()->
				new EmployeeNotFoundException("Id " + emp.getEmpId() + " not found")); //after jdk8 ,nullpointer exception remove cheyyan illa class,kore methods nd to check
	
		id.setEmpName(emp.getEmpName());
		id.setEmpSal(emp.getEmpSal());
		id.setEmpDesignation(emp.getEmpDesignation());
		Employee save = repo.save(id);

		ResponseStructure<Employee> r = new ResponseStructure<>();
		r.setStatus(HttpStatus.OK.value());
		r.setMessage("updated succesfully");
		r.setData(save);
		
		return r;
	}
	
	 /* ---------- SEARCH BY NAME ---------- */
	public ResponseStructure<List<Employee>> getEmpByName(String name) {
	    List<Employee> l= repo.findByEmpName(name);
	    ResponseStructure<List<Employee>> r = new ResponseStructure<>();
	    r.setStatus(HttpStatus.OK.value());
	    r.setMessage(l.isEmpty() ? "No employees found with name " + name
                : "Employees with name " + name + " fetched");
	    r.setData(l);
	    return r;
	}

	  /* ---------- MAXSALARY ---------- */
	public ResponseStructure<Employee> getEmpByMaxSal() {
		Employee all = repo.findAll().stream().max((a,b)->a.getEmpSal()-b.getEmpSal())
							.orElseThrow(() ->
                            new EmployeeNotFoundException("No Employees in DB"));
		ResponseStructure<Employee> r = new ResponseStructure<>();
		r.setStatus(HttpStatus.OK.value());
		r.setMessage("Employee with max-sal is");
		r.setData(all);
		return r;
    }
	
	
}

