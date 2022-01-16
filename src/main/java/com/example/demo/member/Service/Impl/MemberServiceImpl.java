package com.example.demo.member.Service.Impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.components.MailComponents;
import com.example.demo.member.Service.MemberService;
import com.example.demo.member.entity.Member;
import com.example.demo.member.model.MemberInput;
import com.example.demo.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	private final MailComponents mailComponents;
	@Override
	public boolean register(MemberInput parameter) {
		
		Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());
		if (optionalMember.isPresent())
		memberRepository.findById(parameter.getUserId());
		
		String uuid =UUID.randomUUID().toString();
		
		Member member = Member.builder()
				.userID(parameter.getUserId())
				.UserName(parameter.getUserName())
				.UserID(parameter.getPhone())
				.password(parameter.getPassword())
				.RegDt(LocalDateTime.now())
				.EmailAuthYn(false)
				.EmailAuthKey(uuid)
				.build();
		
		memberRepository.save(member);
		
		String email = parameter.getUserId();
		String subject = "lms-project 사이트 가입을 축하드립니다.";
		String text ="<p>lms-project 사이트 가입을 축하드립니다. <p><p>아래 링크를 클릭하셔서 가입을 완료 하세요.</p>"
				+ "<div><a target='_blank' href='http://localhost:8080/member/email-auth?id=" + uuid + "'> 가입 완료 </a></div>";
		mailComponents.sendMail(email, subject, text);
		return false;
	}
	@Override
	public boolean emailAuth(String uuid) {
		
		Optional<member> optionalMember = memberRepository.findByEmailAuthKey(uuid);
		if(!optionalMember.ispresent()) {
			return false;
		}
		
		Member member = optionalMenber.get();
		member.setEmailAuthYn(true);
		member.setEmailAuth(LocalDateTime.now());
		memberRepository.save(member);
		
		return false;
	}

}
