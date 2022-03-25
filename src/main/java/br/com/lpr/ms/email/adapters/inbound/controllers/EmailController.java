package br.com.lpr.ms.email.adapters.inbound.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lpr.ms.email.adapters.inbound.dto.requests.EmailRequestPostDTO;
import br.com.lpr.ms.email.application.entities.Email;
import br.com.lpr.ms.email.application.services.EmailServiceImpl;
import br.com.lpr.ms.email.application.utils.EmailUtils;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailServiceImpl emailService;
	
	@PostMapping("/send")
	public ResponseEntity<?>  send(@RequestBody @Valid EmailRequestPostDTO emailRequest){
		return ResponseEntity.status(HttpStatus.CREATED).body(emailService.send(EmailUtils.getEmailFromRequestPost(emailRequest)));
		
	}
}
