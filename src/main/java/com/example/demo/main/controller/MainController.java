package com.example.demo.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.components.MailComponents;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final MailComponents mailComponents;
	
	@RequestMapping("/")
	public String index() {
		
		
		/*String email = "raveskfn@naver.com";
		String subject = "안녕하세요. 제로베이스 입니다.";
		String text = "<p>안녕하세요. 제로베이스 입니다.</p>";
		
		mailComponents.sendMail(email, subject, text);
		*/
		return "Index";
	}

	/*@RequestMapping("/hello")
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
		*/
	}

}
