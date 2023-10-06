package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.FileUploadService;
import com.example.demo.entity.UploadFile;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/hrms")
public class FileUploadController {
	
	@Value("${project.image}")
	private String path;
	
	@Autowired
	private FileUploadService fileService;
	
	@PostMapping("/upload")
 public UploadFile fileUpload(@RequestParam("image") MultipartFile filename) throws Exception{
	 
	
		 
		  return fileService.imageUpload(path, filename);
		
 }
	
	
	@GetMapping("/image/{imageName}")
	public void downloadIamge(@PathVariable("imageName") String imageName,HttpServletResponse response) throws IOException {
		
		InputStream stream= fileService.getUploadedFile(path, imageName);
		
		response.setContentType(org.springframework.http.MediaType.IMAGE_JPEG_VALUE);
		
		org.springframework.util.StreamUtils.copy(stream,response.getOutputStream());
	}
}
