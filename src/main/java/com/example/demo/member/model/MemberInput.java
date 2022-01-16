package com.example.demo.member.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MemberInput {

	
	private String userID;
	private String userName;
	private String password;
	private String phone;
	
}
