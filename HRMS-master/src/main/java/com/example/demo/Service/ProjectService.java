
package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProjectRepository;
import com.example.demo.entity.Project;

@Service

public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveProject(Project project) {
		
		return projectRepository.save(project);
	}
	
	public List<Project> getProjectDetails() {
		
		return projectRepository.findAll();
	}
	
	public Optional<Project> projectGetById(int  projectId) {
		return projectRepository.findById(projectId);
	}
	
	public void projectDeleteById(int projectId) {
		projectRepository.deleteById(projectId);
	}
	public Project saveOrUpdate(int projectId,Project project) {
		
		Project pro=projectRepository.findById(projectId).get();
		pro.setName(project.getName());
		pro.setAssignDate(project.getAssignDate());
		pro.setSubmiDate(project.getSubmiDate());
		pro.setProjectDescription(project.getProjectDescription());
		return projectRepository.save(pro);
	}
}
