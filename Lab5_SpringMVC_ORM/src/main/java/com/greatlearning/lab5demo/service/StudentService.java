package com.greatlearning.lab5demo.service;

import java.util.List;

import com.greatlearning.lab5demo.entity.Student;


public interface StudentService {
	public List<Student> getStudents();
	public void saveStudent(Student theStudent);
	public Student getStudent(int theId);
	public void deleteStudent(int theId);
	
}
