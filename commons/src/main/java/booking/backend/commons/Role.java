package booking.backend.commons;

import java.util.Optional;

public enum Role {

  LANDLORD(1),
  CLIENT(2),
  ADMIN(3);

  private final int id;

  Role(int id) {
    this.id = id;
  }

  public static Optional<Role> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value: Role.values()) {
      if (value.id == id) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }

  public int getId() {
    return id;
  }
}
