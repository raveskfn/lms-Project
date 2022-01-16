package com.example.demo.components;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MailComponents {

	private final JavaMailSender javamailSender;
	
	public void sendMail(String mail, String subject, String text) {
		
		boolean result = false;
		
		MimeMessagePreparator msg = new MimeMessagePreparator();
		@Override
		public void prepare(MimeMessage mimeMessage) throws Exception {
			
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setTo(mail);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(text, true);
		
		}
		
		
		try {
		javaMailSender.send(msg);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
