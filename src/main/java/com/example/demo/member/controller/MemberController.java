package com.example.demo.member.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.member.Service.MemberService;
import com.example.demo.member.entity.Member;
import com.example.demo.member.model.MemberInput;
import com.example.demo.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
	
	private final MemberService memberService;
	
	
	@RequestMapping("/member/login")
	public String login() {
		
		return "member/login";
	}
	
	
	@GetMapping("/member/register")
	public String register() {
		
		return "member/register";
	}
	
	@PostMapping("/member/register")
	public String registerSubmit(Model model, HttpServletRequest request, HttpServletResponse response
			, MemberInput parameter) {
		
		boolean result = memberService.register(parameter);
		model.addAttribute("result", result);
		
		
		
		return "member/register_complete";
	}
	
	@GetMapping("/member/email-auth")
	public String emailAuth(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		System.out.println(uuid);
		
		boolean result = memberService.emailAuth(uuid);
		model.addAttribute("result", result);
		
		return "member/email_auth";
		
	}
	@GetMapping("/member/info")
	public String memberInfo() {
		
		return "member/info";
	}
	
}
