package br.com.lpr.ms.email.dto.requests;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmailRequestPostDTO {
	
	@JsonProperty("userid")
	private UUID userId;
	
	@NotBlank(message= "Remetente não pode estar vazio")
	@Email(message = "Remetente não é um email valido")
	private String from;
	
	private String password;
	
	@NotBlank(message = "Destinatario não pode estar vazio!")
	@Email(message = "Destinatario não é um email valido!")
	private String to;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String body;
	
	
}
