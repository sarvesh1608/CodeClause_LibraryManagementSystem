package com.librarymanagement.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String loadIndexPage() {
		return "view/index";
	}

}
