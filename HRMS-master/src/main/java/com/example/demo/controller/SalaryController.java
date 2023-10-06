package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SalaryService;
import com.example.demo.entity.Salary;

@RestController
@RequestMapping("/hrms")
public class SalaryController {

	@Autowired
 private SalaryService  salaryService;
	
	@PostMapping("/addSalary")
	public Salary saveSalary(@RequestBody Salary salary) {
		return salaryService.saveSalary(salary);
	}
	
	@GetMapping("/getSalary")
	public  List<Salary> getAllSalaryDetails() {
		return salaryService.getAllSalaryDetails();
	}
	@GetMapping("/salaryGetById/{salaryId}")
	public ResponseEntity<Salary> salaryGetById(@PathVariable int salaryId) {
		return ResponseEntity.of(salaryService.salaryGetById(salaryId)); 
	}
	
//	@PutMapping("/updateSalary/{salaryId}")
//	public void updateSalaryDetails(@PathVariable int salaryId,@RequestBody Salary salary) {
//		salaryService.updataeSalaryDetails(salaryId, salary);
//	}
	
	@DeleteMapping("/deleteSalaryById/{salaryId}")
	public void deleteSalaryById(@PathVariable int salaryId) {
		salaryService.SalaryDeleteById(salaryId);
	}
}
