package br.com.lpr.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.lpr.ms.email.dto.requests.EmailRequestPostDTO;
import br.com.lpr.ms.email.entities.Email;
import br.com.lpr.ms.email.services.EmailService;

@Component
public class EmailConsumer {

	@Autowired
	private EmailService emailService;
	
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void listen(@Payload EmailRequestPostDTO emailRequest) {
		Email email = emailService.send(emailRequest);
		System.out.println("EMAIL STATUS: "+email.getStatus());
	}
}
