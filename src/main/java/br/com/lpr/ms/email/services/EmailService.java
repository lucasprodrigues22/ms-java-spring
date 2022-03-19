package br.com.lpr.ms.email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lpr.ms.email.entities.Email;
import br.com.lpr.ms.email.repositories.IEmailRepository;

@Service
public class EmailService {

	@Autowired
	private IEmailRepository repository;
	
	public void send(Email email) {
		
	}

	
}
