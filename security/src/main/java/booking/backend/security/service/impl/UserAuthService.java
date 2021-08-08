package booking.backend.security.service.impl;

import booking.backend.commons.Role;
import booking.backend.service.security.Profile;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

  private final ObjectProvider<Profile> profileProvider;

  @Autowired
  public UserAuthService(ObjectProvider<Profile> profileProvider) {

    this.profileProvider = profileProvider;
  }

  public boolean canUpdateUser(int id) {
    final var profile = profileProvider.getIfAvailable();
    if (profile == null) {
      return false; // unauthenticated users cannot update anyone
    }
    if (profile.getRole() == Role.ADMIN) {
      return true; // admins can update anyone
    }

    return profile.getId() == id; // users can update themselves
  }
}
