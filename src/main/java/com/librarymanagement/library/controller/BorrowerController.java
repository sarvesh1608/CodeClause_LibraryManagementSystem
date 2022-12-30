package com.librarymanagement.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.librarymanagement.library.entity.Book;
import com.librarymanagement.library.entity.Borrower;
import com.librarymanagement.library.entity.Staff;
import com.librarymanagement.library.entity.Student;
import com.librarymanagement.library.repository.BookRepository;
import com.librarymanagement.library.repository.StaffRepository;
import com.librarymanagement.library.repository.StudentRepository;
import com.librarymanagement.library.service.BorrowerService;

@Controller
public class BorrowerController {
	
	@Autowired
	BorrowerService borrowerService;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@GetMapping("/borrower")
	public String getAllBorrowerList(Model model) {
		model.addAttribute("borrowerList", borrowerService.getAllBorrower());
		return "view/borrower";
	}
	
	@PostMapping("/addBorrower")
	public String saveBorrower(@ModelAttribute("addBorrower") Borrower borrower, Model model) {
		model.addAttribute("addBorrower", borrowerService.saveBorrower(borrower));
		return "redirect:/borrower";
	}
	
	@GetMapping("/addBorrower")
	public String createBorrower(Model model) {
		Borrower borrower = new Borrower();
		List<Book> books = bookRepository.findAll();
		List<Student> students = studentRepository.findAll();
		List<Staff> staffs = staffRepository.findAll();
		borrower.setBooks(books);
		borrower.setStudents(students);
		borrower.setStaffs(staffs);
		model.addAttribute("books", books);
		model.addAttribute("students", students);
		model.addAttribute("staffs", staffs);
		model.addAttribute("addBorrower", borrower);
		return "view/addBorrower";
		
	}
	
	@GetMapping("/borrower/{id}")
	public String deleteBorrower(@PathVariable Integer id) throws Throwable {
		borrowerService.deleteBorrower(id);
		return "redirect:/borrower";
	}

}
