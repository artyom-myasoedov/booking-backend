package booking.backend.db.entity;

import java.util.Optional;

public enum Role {

  LANDLORD(1),
  CLIENT(2);

  private final Integer id;

  Role(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public static Optional<Role> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : Role.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }
}
