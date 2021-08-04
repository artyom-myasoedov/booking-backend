package booking.backend.db.entity;

import java.util.Optional;

public enum RoomStatus {

  AVAILABLE(1),
  NOT_CONFIRMED(2),
  OCCUPIED(3),
  ;

  private final Integer id;

  RoomStatus(Integer id) {
    this.id = id;
  }

  public static Optional<RoomStatus> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : RoomStatus.values()) {
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
