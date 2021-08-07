package booking.backend.service.model;

import booking.backend.db.entity.TypeOfRent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

  @JsonIgnore
  public TypeOfRent getTypeOfRent() {
    return typeOfRent;
  }

  @JsonProperty("name")
  public void setTypeOfRent(TypeOfRent typeOfRent) {
    this.typeOfRent = typeOfRent;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @JsonProperty("id")
  public Integer getId() {
    return typeOfRent.getId();
  }

  @JsonProperty("numberOfHours")
  public Integer getNumberOfHours() {
    return typeOfRent.getNumberOfHours();
  }

  @JsonProperty("name")
  public String getName() {
    return typeOfRent.toString();
  }
}
