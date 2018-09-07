package org.garrus.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class UserStrategy {

	
	/**
	 * Verifies if the authenticated user  is the same as the resource he wants to update.
	 * @param authentication
	 * @param clienteRut
	 * @return true if username==clienteRut
	 */
	public boolean verifyUpdate(@NonNull UsernamePasswordAuthenticationToken authentication, @NonNull final String username) {
		return authentication.getName().equals(username); 
    }
	
}
