package br.com.lpr.ms.email.adapters.outbound.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lpr.ms.email.application.entities.Email;

@Repository
public interface ISpringDataEmailRepository extends JpaRepository<Email, UUID>{

}
