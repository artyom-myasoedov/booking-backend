package booking.backend.service.model;

import booking.backend.db.entity.TypeOfRent;
import booking.backend.service.validation.RoomExists;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TypeOfRentDto {

  @NotNull(message = "id.is-null")
  @RoomExists
  private Integer roomId;

  @NotNull(message = "typeOfRent.is-null")
  private TypeOfRent typeOfRent;

  @NotNull(message = "price.is-null")
  @Min(0)
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
