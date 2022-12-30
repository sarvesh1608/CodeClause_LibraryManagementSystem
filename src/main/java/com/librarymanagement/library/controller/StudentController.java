package com.librarymanagement.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.librarymanagement.library.entity.Student;
import com.librarymanagement.library.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/studentList")
	public String listAllStudents(Model model) {
		
		model.addAttribute("studentList", studentService.getAllStudents());
		return "view/studentList";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("student", studentService.saveStudent(student));
//		studentService.saveStudent(student);
		return "redirect:/studentList";
		
	}
	
	@GetMapping("/students")
	public String addNewStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);//@ModelAttribute("student") Student student,
		return "view/students";
	}
	
	@GetMapping("/studentList/{id}")
	public String deleteBorrower(@PathVariable Integer id) throws Throwable {
		studentService.deleteStudent(id);
		return "redirect:/studentList";
	}

	
}
