package br.com.lpr.ms.email.services;

import java.time.LocalDateTime;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import br.com.lpr.ms.email.dto.requests.EmailRequestPostDTO;
import br.com.lpr.ms.email.entities.Email;
import br.com.lpr.ms.email.repositories.IEmailRepository;
import br.com.lpr.ms.email.status.EmailStatus;
import br.com.lpr.ms.email.utils.EmailUtils;

@Service
public class EmailService {

	@Autowired
	private IEmailRepository repository;
	
	@Value("${ms.email.gmail.port}") 
	private  String emailPort;
	
	@SuppressWarnings("finally")
	public Email send(EmailRequestPostDTO emailRequest) {
		Email email = EmailUtils.getEmailFromRequestPost(emailRequest);
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailRequest.getTo());
			message.setSubject(emailRequest.getSubject());
			message.setText(emailRequest.getBody());
			
			JavaMailSender emailSender = getJavaMail(emailRequest.getFrom(),emailRequest.getPassword());
			emailSender.send(message);
			
			email.setSendDate(LocalDateTime.now());
			email.setStatus(EmailStatus.SENT);
		}catch(MailException e) { 
			e.printStackTrace();
			email.setStatus(EmailStatus.ERROR);
		} finally {
			return repository.save(email);
		}
	}
	
	private JavaMailSender getJavaMail(String username, String password) {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		emailSender.setUsername(username);
		emailSender.setPassword(password);
		
		Properties prop = new Properties(); 
		prop.put("mail.smtp.host", "smtp.gmail.com");  
		prop.put("mail.smtp.auth", "true");  
		prop.put("mail.smtp.port", emailPort);  // ou 587
		prop.put("mail.smtp.starttls.enable", "true");  
		prop.put("mail.smtp.socketFactory.port", emailPort);  // ou 587
		prop.put("mail.smtp.socketFactory.fallback", "false");  
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		emailSender.setJavaMailProperties(prop);
		
		return emailSender;
	}
	
	
	
}
