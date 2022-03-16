package br.com.lpr.ms.email.dto.requests;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class EmailRequestPostDTO {
	
	@NotBlank
	private UUID userId;
	
	@NotBlank
	private String from;
	
	@NotBlank
	private String to;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;
	
}
