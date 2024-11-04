package com.gogreen.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.internet.MimeMessage;

@SpringBootApplication
@RestController
public class EmailWithGmailSmtpApplication {

	@Autowired
	private JavaMailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(EmailWithGmailSmtpApplication.class, args);
	}

	@GetMapping("/")
	public String sendEmail() throws Exception {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);
		messageHelper.setFrom("pavanleo466@gmail.com", "Testing Gmail SMTP");
		messageHelper.setTo("dummy.for.smtp.integration@gmail.com");
		messageHelper.setSubject("Testing Gmail SMTP !!!");
		messageHelper.setText("<<<<<<<<<<Testing Gmail SMTP !!!>>>>>>>>>>");
		mailSender.send(message);
		return "Email Sent Successfully !!!";
	}
}
