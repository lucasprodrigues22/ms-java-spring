package br.com.lpr.ms.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lpr.ms.email.entities.Email;

public interface IEmailRepository extends JpaRepository<Email, UUID> {

}
