package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UploadFile {

	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

private String  filename;
private String message;

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public UploadFile() {

	// TODO Auto-generated constructor stub
}
public UploadFile(int id, String filename, String message) {
	super();
	this.id = id;
	this.filename = filename;
	this.message = message;
}



}
