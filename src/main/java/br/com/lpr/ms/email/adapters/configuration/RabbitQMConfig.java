package br.com.lpr.ms.email.adapters.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lucas Rodrigues
 */
@Configuration
public class RabbitQMConfig {
	
	@Value("ms.email")
	private String queue;
	
	@Value("amqps://czehugwm:1bviVidpocnfYFuvLQyh8rBDOkX4c9zB@fish.rmq.cloudamqp.com/czehugwm")
	private String uri;
	
	
	/**
	 * Configuração do rabbitMQ para conexão
	 */
	@Bean
	public ConnectionFactory rabbitConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setUri(uri);
		return connectionFactory;
	}
	
	
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
