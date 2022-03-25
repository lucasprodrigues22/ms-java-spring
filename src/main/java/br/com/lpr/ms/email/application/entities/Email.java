package br.com.lpr.ms.email.application.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import br.com.lpr.ms.email.application.enums.EmailStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "tb_email")
public class Email {

	@Id
	@Type(type = "uuid-char")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Type(type = "uuid-char")
	@Column(name = "userid")
	private UUID userId;
	
	@Column(name="dsfrom", nullable = false)
	private String from;
	
	@Column(nullable = false)
	private String to;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(nullable = false, columnDefinition = "text")
	private String body;
	
	@Column(name = "senddate", nullable = true)
	private LocalDateTime sendDate;
	
	@Enumerated(EnumType.STRING)
	private EmailStatus status;
	
	@Transient
	private String password;
}
