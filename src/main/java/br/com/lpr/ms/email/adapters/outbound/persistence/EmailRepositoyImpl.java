package br.com.lpr.ms.email.adapters.outbound.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.lpr.ms.email.application.entities.Email;
import br.com.lpr.ms.email.application.ports.IEmailRepository;

@Component
@Primary
public class EmailRepositoyImpl implements IEmailRepository {

	private final ISpringDataEmailRepository repository;
	
	public EmailRepositoyImpl(final ISpringDataEmailRepository repository) {
		this.repository = repository;
	}

	@Override
	public Email save(Email email) {
		return this.repository.save(email);
	}

	@Override
	public Page<Email> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Override
	public Optional<Email> findById(UUID id) {
		return this.repository.findById(id);
	}

}
