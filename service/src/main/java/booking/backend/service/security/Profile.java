package booking.backend.service.security;

import booking.backend.commons.Role;
import org.immutables.value.Value;


@Value.Immutable
public interface Profile {

  int getId();

  String getUsername();

  String getFirstName();

  String getLastName();

  String getPhoneNumber();

  String getEmail();

  Role getRole();
}
