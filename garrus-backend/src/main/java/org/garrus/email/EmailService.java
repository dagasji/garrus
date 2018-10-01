package org.garrus.email;

public interface EmailService {

	/**
	 * Sends a simple email text asynchronously
	 * @param to Email to
	 * @param subject Subjet
	 * @param text MEssage body HTML
	 */
	void sendSimpleMessage(String to, String subject, String text);


}
