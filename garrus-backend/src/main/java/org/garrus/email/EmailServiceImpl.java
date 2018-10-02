package org.garrus.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{
  
    @Autowired
    private JavaMailSender emailSender;
    
 
    private class EnvioAsincrono implements Runnable{
    	 SimpleMailMessage message;

		@Override
		public void run() {
			emailSender.send(message);			
		} 
    	
    	
    }

    @Override
    public void sendSimpleMessage(
      String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        message.setFrom("contacto@coding12.cl");
        EnvioAsincrono envio = new EnvioAsincrono();
        envio.message = message;
        Thread thread = new Thread(envio);
    	thread.start();
    }

}
