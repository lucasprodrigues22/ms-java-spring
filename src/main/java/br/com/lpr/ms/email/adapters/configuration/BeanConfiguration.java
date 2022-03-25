package br.com.lpr.ms.email.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.lpr.ms.email.MsEmailApplication;
import br.com.lpr.ms.email.application.ports.IEmailRepository;
import br.com.lpr.ms.email.application.services.EmailServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MsEmailApplication.class)
public class BeanConfiguration {

	@Bean
	EmailServiceImpl emailServiceImpl(IEmailRepository repository) {
		return new EmailServiceImpl(repository);
	}
}
