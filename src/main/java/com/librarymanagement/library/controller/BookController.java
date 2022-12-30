package com.librarymanagement.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.librarymanagement.library.entity.Book;
import com.librarymanagement.library.entity.Student;
import com.librarymanagement.library.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/bookList")
	public String listAllBooks(Model model) {
		model.addAttribute("bookList", bookService.getAllBooks());
		return "view/bookList";
	}
	
	@PostMapping("/addBook")
	public String saveBook(@ModelAttribute("addBook") Book book, Model model) {	
		model.addAttribute("addBook", bookService.saveBook(book));
		return "redirect:/bookList";
	}
	
	@GetMapping("/addBook")
	public String addNewBook(Model model) {
		Book book = new Book();
		model.addAttribute("addBook", book);
		return "view/addBook";
	}
	
//	@PostMapping("/updateBook")
//	public String updateBook(@ModelAttribute("updateBook") Book book, BindingResult
//			result, Model model) {
//		bookService.updateBookDetails(book);
//		model.addAttribute(book, book)
//		return "redirect:/addBook";
//	}
	
	@RequestMapping("/deleteBooks/{id}")
	public String deleteBooks(@PathVariable("id") Integer id, Model model) {
		bookService.deleteBook(id);
		model.addAttribute("book", bookService.getAllBooks());
		return "redirect:/bookList";
	}

}
