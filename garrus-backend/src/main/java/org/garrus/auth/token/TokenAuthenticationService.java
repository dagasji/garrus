package org.garrus.auth.token;

import java.util.Objects;
import java.util.Optional;

import org.garrus.auth.UserAuthenticationService;
import org.garrus.user.UserDTO;
import org.garrus.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;

@Service
final class TokenAuthenticationService implements UserAuthenticationService {
  @Autowired
  private TokenService tokens;
  @Autowired
  private UserService users;

  @Override
  public Optional<String> login(final String username, final String password) {
    return users
      .findByUsername(username)
      .filter(user -> Objects.equals(password, user.getPassword()))
      .map(user -> tokens.expiring(ImmutableMap.of("username", username)));
  }

  @Override
  public Optional<UserDTO> findByToken(final String token) {
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
