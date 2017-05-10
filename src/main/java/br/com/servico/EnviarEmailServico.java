package br.com.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailServico {
	
	@Autowired
	private MailSender mailer;

	public void enviarEmailParaUsuario(String emailTo, String subject, String msg) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(emailTo);
		email.setSubject(subject);
		email.setText(msg);
		mailer.send(email);
	}
}
