package br.com.lpr.ms.email.application.ports;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.lpr.ms.email.application.entities.Email;

public interface IEmailRepository {

	Email save(Email email);
	Page<Email>findAll(Pageable pageable);
	Optional<Email> findById(UUID id);
}
