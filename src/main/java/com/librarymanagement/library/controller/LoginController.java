package com.librarymanagement.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.librarymanagement.library.entity.Staff;
import com.librarymanagement.library.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	Staff staff = new Staff();
	
	@PostMapping("/login")
	public String checkValidCredentials(@ModelAttribute("staff") Staff staff) {
		
//		model.addAttribute("students", studentService.getAllStudents());
		boolean flag = loginService.checkCredentials(staff);
		if(flag) {
			return "redirect:/home";
		}
		return null;
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("login");
		return "view/Login";
	}
}
