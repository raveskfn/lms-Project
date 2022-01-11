package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPage {
	
	@RequestMapping("/")
	public String index() {
		
		return "Main Page";
	}


}
