package booking.backend.security.service.impl;

import booking.backend.service.security.BookingPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BookingPasswordEncoderImpl implements BookingPasswordEncoder {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public BookingPasswordEncoderImpl(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public String encode(CharSequence rawPassword) {
    return passwordEncoder.encode(rawPassword);
  }
}
