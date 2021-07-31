package booking.backend.db.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class RoomTypeOfRentId implements Serializable {
  @Column(name = "type_of_rent_id")
  private TypeOfRent typeOfRentId;

  @Column(name = "room_id")
  private Integer roomId;

  public TypeOfRent getTypeOfRentId() {
    return typeOfRentId;
  }

  public void setTypeOfRentId(TypeOfRent typeOfRentId) {
    this.typeOfRentId = typeOfRentId;
  }

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RoomTypeOfRentId)) return false;
    RoomTypeOfRentId that = (RoomTypeOfRentId) o;
    return Objects.equals(typeOfRentId, that.typeOfRentId) && Objects.equals(roomId, that.roomId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeOfRentId, roomId);
  }
}
