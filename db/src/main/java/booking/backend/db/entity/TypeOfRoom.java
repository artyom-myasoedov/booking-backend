package booking.backend.db.entity;

import java.util.Optional;

public enum TypeOfRoom {

  CLASS(1),
  THEATRE(2),
  ROUND_TABLE(3),
  CONVERSATION(4),
  ;

  private final Integer id;

  TypeOfRoom(Integer id) {

    this.id = id;
  }

  public static Optional<TypeOfRoom> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : TypeOfRoom.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }

  public Integer getId() {
    return id;
  }
}
