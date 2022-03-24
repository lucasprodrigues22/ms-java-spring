package br.com.lpr.ms.email;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lucas Rodrigues
 */
@Configuration
public class RabbitQMConfig {
	
	@Value("${spring.rabbitmq.queue}")
	private String queue;
	
	
	/**
	 * Método para criar uma Queue, que nossa aplicação vai escutar no RabbitMQ.
	 */
	@Bean
	public Queue queue() {
		return new Queue(queue, true);
	}
	
	/**
	 * Conversor global para mensagens dos consumers
	 * @return
	 */
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
