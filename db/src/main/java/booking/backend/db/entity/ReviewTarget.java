package booking.backend.db.entity;

import java.util.Optional;

public enum ReviewTarget {
  USER(1),
  ROOM(2);

  private final Integer id;

  ReviewTarget(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public static Optional<ReviewTarget> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : ReviewTarget.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }
}
