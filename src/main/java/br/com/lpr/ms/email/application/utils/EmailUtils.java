package br.com.lpr.ms.email.application.utils;

import org.springframework.beans.BeanUtils;

import br.com.lpr.ms.email.adapters.inbound.dto.requests.EmailRequestPostDTO;
import br.com.lpr.ms.email.application.entities.Email;

public class EmailUtils {

	
	public static Email getEmailFromRequestPost(EmailRequestPostDTO emailRequest) {
		Email email = new Email();
		BeanUtils.copyProperties(emailRequest, email);
		return email;
	}
}
