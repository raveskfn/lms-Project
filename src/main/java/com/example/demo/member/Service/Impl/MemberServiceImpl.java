package com.example.demo.member.Service.Impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.demo.components.MailComponents;
import com.example.demo.member.Service.MemberService;
import com.example.demo.member.entity.Member;
import com.example.demo.member.exception.MemberNotEmailAuthException;
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
		if (optionalMember.isPresent()) {
			return false;
		}
		String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());
		
		String uuid =UUID.randomUUID().toString();
		
		Member member = Member.builder()
				.userID(parameter.getUserId())
				.UserName(parameter.getUserName())
				.UserID(parameter.getPhone())
				.password(encPassword)
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
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> optionalMember = memberRepository.findById(username);
		if (!optionalMember.isPresent()) {
			throw new UsernameNotFoundException("회원 정보가 존재핮디 않습니다");
		}
		
		Member member = optionalMember.get();
		
		if (!member.isEmailAuthYn()) {
			throw new MemberNotEmailAuthException("이메일 활성화 이후에 로그인을 해주세요.");
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		
		return new User(member.getUserId(), member.getPassword(), grantedAuthorities );
	}

}
