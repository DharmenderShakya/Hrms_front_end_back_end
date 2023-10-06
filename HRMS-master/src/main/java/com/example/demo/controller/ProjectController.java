package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProjectService;
import com.example.demo.entity.Project;

@RestController
@RequestMapping("/hrms")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/addProject")
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		
		return ResponseEntity.ok(projectService.saveProject(project));
	}
	
	@GetMapping("/getProjectDetails")
	public List<Project> getProjectDetails(){
		
		return projectService.getProjectDetails();
	}
	
	@GetMapping("/getByProjectId/{projectId}")
	public ResponseEntity<Project> projectGetById(@PathVariable int projectId) {
		return ResponseEntity.of(projectService.projectGetById(projectId));
	}
	
	@PutMapping("/updateProject/{projectId}")
	public Project saveOrUpdate(@PathVariable int projectId,@RequestBody Project project) {
		
		return projectService.saveOrUpdate(projectId, project);
		
	}
	
	@DeleteMapping("/deleteProjectById/{projectId}")
	public void projectDeleteById(@PathVariable int projectId) {
		projectService.projectDeleteById(projectId);
	}
	
}
