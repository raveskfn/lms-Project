package com.example.demo.member.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.member.model.MemberInput;

public interface MemberService extends UserDetailsService{

	boolean register(MemberInput parameter);
	
	boolean emailAuth(String uuid);
}
