package br.com.lpr.ms.email.utils;

import org.springframework.beans.BeanUtils;

import br.com.lpr.ms.email.dto.requests.EmailRequestPostDTO;
import br.com.lpr.ms.email.entities.Email;

public class EmailUtils {

	
	public static Email getEmailFromRequestPost(EmailRequestPostDTO emailRequest) {
		Email email = new Email();
		BeanUtils.copyProperties(emailRequest, email);
		return email;
	}
}
