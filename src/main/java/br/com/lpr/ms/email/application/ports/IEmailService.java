package br.com.lpr.ms.email.application.ports;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lpr.ms.email.application.entities.Email;

@Service
public interface IEmailService {

	
	Email send(Email email);
	Page<Email> findAll(Pageable pageable);
	Optional<Email> findById(UUID id);
	
	
	
}
