package com.example.demo.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.FileUploadRepo;
import com.example.demo.entity.UploadFile;

@Service
public class FileUploadService{

	@Autowired
	FileUploadRepo fileUploadRepo;
	
	
	
	
	public UploadFile imageUpload(String path,MultipartFile multipartFile) throws Exception{
		UploadFile uploadFile=new UploadFile();
		
		String name=multipartFile.getOriginalFilename();
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(name.substring(name.lastIndexOf("")));
		String filePath=path+File.separator+fileName1;
		System.out.print(fileName1);
		uploadFile.setFilename(fileName1);
		File file=new File(path);
		if(!file.exists()) {
			
			file.mkdir();
	
		}
		Files.copy(multipartFile.getInputStream(),Paths.get(filePath));
		return fileUploadRepo.save(uploadFile);
	}
	
	
	public InputStream getUploadedFile(String pathName,String fileName) throws FileNotFoundException {
		
		String fullPath=pathName+File.separator+fileName;
		InputStream file=new FileInputStream(fullPath);
		return file;
	}
	
}
