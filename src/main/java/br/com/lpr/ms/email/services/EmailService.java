package br.com.lpr.ms.email.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lpr.ms.email.entities.Email;
import br.com.lpr.ms.email.repositories.EmailRepository;

public class EmailService {

	@Autowired
	private EmailRepository repository;
	
	public void send(Email email) {
	}

	
}
