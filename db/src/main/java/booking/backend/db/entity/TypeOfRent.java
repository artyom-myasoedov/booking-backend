package booking.backend.db.entity;

import java.util.Optional;

//TODO как сделать тип аренды? оставить в енам или переделать в класс или и так и так
public enum TypeOfRent {

  BY_HOUR(1, 1),
  BY_DAY(24, 2),
  BY_WEEK(168, 3),
  BY_MONTH(720, 4),
  ;

  private final Integer numberOfHours;
  private final Integer id;
  private Integer price;

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

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
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
