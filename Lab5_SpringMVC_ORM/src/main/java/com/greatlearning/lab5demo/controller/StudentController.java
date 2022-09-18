package com.greatlearning.lab5demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.lab5demo.entity.Student;
import com.greatlearning.lab5demo.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentsvc;

	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentsvc.getStudents();
		theModel.addAttribute("Students", theStudents);
		return "list-student";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		
		Student theStudent = new Student();
//		System.out.println(id);
		if (id != 0) {
			theStudent = studentsvc.getStudent(id);
//			theStudent.setId(theStudent.getId());
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else {
			theStudent = new Student(name, department, country);
		}
			
		// save the Student
		studentsvc.saveStudent(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";

	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {

		// get the Student from the service
		Student theStudent = studentsvc.getStudent(theId);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		return "student-form";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int theId) {
		studentsvc.deleteStudent(theId);
		return  "redirect:/student/list";
		
	}
}
