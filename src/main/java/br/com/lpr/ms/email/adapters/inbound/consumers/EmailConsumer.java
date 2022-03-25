package br.com.lpr.ms.email.adapters.inbound.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.lpr.ms.email.adapters.inbound.dto.requests.EmailRequestPostDTO;
import br.com.lpr.ms.email.application.entities.Email;
import br.com.lpr.ms.email.application.ports.IEmailService;
import br.com.lpr.ms.email.application.utils.EmailUtils;

@Component
public class EmailConsumer {

	@Autowired
	private IEmailService emailService;
	
	
	@RabbitListener(queues = "ms.email")
	public void listen(@Payload EmailRequestPostDTO emailRequest) {
		Email email = EmailUtils.getEmailFromRequestPost(emailRequest);
		email = emailService.send(email);
		System.out.println("EMAIL STATUS: "+email.getStatus());
	}
}
