package org.garrus.auth.token;

import java.util.Objects;
import java.util.Optional;

import org.garrus.auth.UserAuthenticationService;
import org.garrus.user.UserDTO;
import org.garrus.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;

@Service
final class TokenAuthenticationService implements UserAuthenticationService {
  @Autowired
  private TokenService tokens;
  @Autowired
  private UserService users;


	@Autowired
	private PasswordEncoder passwordEncoder;
	
  /**
   * Removes the Bearer: part of the authorizaiton header.
   * @param authorizationHeader HTTP authorization header with Bearer.
   * @return just the JWT token.
   */
  public static String getToken(String authorizationHeader) {
	  return authorizationHeader.substring(7);
  }
  
  @Override
  public Optional<String> login(final String username, final String password) {
    return users
      .findByUsername(username)
      .filter(user -> passwordEncoder.matches(password, user.getPassword()))
      .map(user -> tokens.expiring(ImmutableMap.of("username", username)));
  }

  @Override
  public Optional<UserDTO> findByToken(String token) {
	if (token.contains("Bearer"))
			token = getToken(token);
    return Optional
      .of(tokens.verify(token))
      .map(map -> map.get("username"))
      .flatMap(users::findByUsername);
  }

  @Override
  public void logout(final UserDTO user) {
    // Nothing to doy
  }
}
