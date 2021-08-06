package booking.backend.service.model;

import booking.backend.db.entity.TypeOfRent;

import java.math.BigDecimal;

public class TypeOfRentDto {

  private Integer roomId;

  private TypeOfRent typeOfRent;

  private BigDecimal price;

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
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
