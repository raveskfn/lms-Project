package com.example.demo.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member {

		@Id
		private String userID;
		private String userName;
		private String phone;
		private String password;
		private LocalDateTime regDt;
		
		private boolean emailAuthYn;
		private LocalDateTime emailAuthDt;
		private String emailAuthKey;
}
