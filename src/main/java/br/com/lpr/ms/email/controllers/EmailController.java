package br.com.lpr.ms.email.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lpr.ms.email.dto.requests.EmailRequestPostDTO;
import br.com.lpr.ms.email.entities.Email;
import br.com.lpr.ms.email.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<?>  send(@RequestBody @Valid EmailRequestPostDTO emailRequest){
		Email email = new Email();
		BeanUtils.copyProperties(emailRequest, email);
		emailService.send(email);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		
	}
}
