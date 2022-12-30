package com.librarymanagement.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.librarymanagement.library.entity.Staff;
import com.librarymanagement.library.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/addNewUser")
	public String registerStaff(@ModelAttribute("addNewUser") Staff staff) {
		registrationService.saveStaffDetails(staff);
		return "redirect:/staffList";
	}
}
