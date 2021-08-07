package booking.backend.service.model;

import booking.backend.db.entity.RoomStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class RoomDto extends RoomCreateDto {


  private Integer id;

  @JsonProperty("status")
  private RoomStatus roomStatus;

  private BigDecimal rating;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoomStatus getRoomStatus() {
    return roomStatus;
  }

  public void setRoomStatus(RoomStatus roomStatus) {
    this.roomStatus = roomStatus;
  }

  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }
}
