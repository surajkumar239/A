package com.becoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EmployeeController {
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
}
