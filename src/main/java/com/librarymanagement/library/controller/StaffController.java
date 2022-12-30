package com.librarymanagement.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.librarymanagement.library.entity.Borrower;
import com.librarymanagement.library.entity.Staff;
import com.librarymanagement.library.entity.Student;
import com.librarymanagement.library.service.StaffService;

@Controller
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@GetMapping("/staffList")
	public String listAllStaff(Model model) {
		
		model.addAttribute("staffList", staffService.getAllStaff());
		return "view/staffList";
		
	}
	
	@GetMapping("/addNewUser")
	public String createUser(Model model) {
		Staff staff = new Staff();
		model.addAttribute("addNewUser", staff);
		return "view/Registration";
	}
	
	@GetMapping("/staffList/{id}")
	public String deleteBorrower(@PathVariable Integer id) throws Throwable {
		staffService.deleteStaff(id);
		return "redirect:/staffList";
	}
}
