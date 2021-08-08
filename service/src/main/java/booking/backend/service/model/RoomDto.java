package booking.backend.service.model;

import booking.backend.db.entity.RoomStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RoomDto extends RoomCreateDto {


  @NotNull(message = "id.is-null")
  private Integer id;

  @JsonProperty("status")
  @NotNull(message = "roomStatus.is-null")
  private RoomStatus roomStatus;

  @NotNull(message = "rating.is-null")
  @Min(value = 0, message = "rating.is-negative")
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
