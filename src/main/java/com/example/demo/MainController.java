package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		
		return "Index";
	}

	@RequestMapping("/hello")
	public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter printWriter = response.getWriter();
		
		String msg = "<html>" +
				"<head>" +
				"</head>" +
				"<body>" +
				"<p>hello</p> <p>lms Website!!!</p>" +
				"<p>안녕하세요!!!</p>" +
				"</body>" +
				"</html>" ;
		
		printWriter.write(msg);
		printWriter.close();
		
	}

}
