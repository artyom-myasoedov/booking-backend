package booking.backend.service.model;

import booking.backend.db.entity.TypeOfRent;

import java.math.BigDecimal;

public class TypeOfRentDto {

  private Integer room_id;

  private TypeOfRent typeOfRent;

  private BigDecimal price;

  public Integer getRoom_id() {
    return room_id;
  }

  public void setRoom_id(Integer room_id) {
    this.room_id = room_id;
  }

  public TypeOfRent getTypeOfRent() {
    return typeOfRent;
  }

  public void setTypeOfRent(TypeOfRent typeOfRent) {
    this.typeOfRent = typeOfRent;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
