package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Repository.SalaryRepo;
import com.example.demo.entity.Salary;

@Service
public class SalaryService {
	
@Autowired
private SalaryRepo salaryRepo;


public Salary saveSalary(Salary salary) {
	
	return salaryRepo.save(salary);
}

public List<Salary> getAllSalaryDetails(){
	
	return salaryRepo.findAll();
}

public void  updataeSalaryDetails(int salaryId,Salary salary) {
	Salary sal=salaryRepo.findById(salaryId).get();
	sal.setSalary(salary.getSalary());
	sal.setEmployeeName(salary.getEmployeeName());
	sal.setMonth(salary.getMonth());
	salaryRepo.save(sal);
}

public Optional<Salary> salaryGetById(int salaryId) {
	
	return salaryRepo.findById(salaryId);
}

public  void SalaryDeleteById(int salaryId) {
	
	salaryRepo.deleteById(salaryId);
}
}
