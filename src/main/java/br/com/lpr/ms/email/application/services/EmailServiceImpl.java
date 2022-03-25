package br.com.lpr.ms.email.application.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.com.lpr.ms.email.application.entities.Email;
import br.com.lpr.ms.email.application.enums.EmailStatus;
import br.com.lpr.ms.email.application.ports.IEmailService;
import br.com.lpr.ms.email.application.ports.IEmailRepository;

public class EmailServiceImpl implements IEmailService {

	private IEmailRepository repository;
	
	@Value("${ms.email.gmail.port}")
	private String emailPort;
	
	public EmailServiceImpl(IEmailRepository repository) {
		this.repository = repository;
	}

	public EmailServiceImpl() {
	}
	
	@SuppressWarnings("finally")
	public Email send(Email email) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getTo());
			message.setSubject(email.getSubject());
			message.setText(email.getBody());
			
			JavaMailSender emailSender = getJavaMail(email.getFrom(),email.getPassword());
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
	

	@Override
	public Page<Email> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Email> findById(UUID id) {
		return repository.findById(id);
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
