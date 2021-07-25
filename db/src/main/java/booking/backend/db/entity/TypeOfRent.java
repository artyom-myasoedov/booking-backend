package booking.backend.db.entity;

import java.util.Optional;

public enum TypeOfRent {

  BY_HOUR(1, 1),
  BY_DAY(24, 2),
  BY_WEEK(168, 3),
  BY_MONTH(720, 4),
  ;

  private final Integer numberOfHours;
  private final Integer id;

  TypeOfRent(Integer numberOfHours, Integer id) {
    this.numberOfHours = numberOfHours;
    this.id = id;
  }

  public Integer getNumberOfHours() {
    return numberOfHours;
  }

  public Integer getId() {
    return id;
  }

  public static Optional<TypeOfRent> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : TypeOfRent.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }
}
