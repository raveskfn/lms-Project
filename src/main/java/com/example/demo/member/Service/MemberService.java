package com.example.demo.member.Service;

import com.example.demo.member.model.MemberInput;

public interface MemberService {

	boolean register(MemberInput parameter);
	
	boolean emailAuth(String uuid);
}
