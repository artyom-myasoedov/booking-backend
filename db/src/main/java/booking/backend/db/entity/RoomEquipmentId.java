package booking.backend.db.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class RoomEquipmentId implements Serializable {

  @Column(name = "room_id")
  private Integer roomId;

  @Column(name = "equipment_name")
  private String equipmentName;

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public String getEquipmentName() {
    return equipmentName;
  }

  public void setEquipmentName(String equipmentName) {
    this.equipmentName = equipmentName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RoomEquipmentId that = (RoomEquipmentId) o;
    return Objects.equals(roomId, that.roomId) && Objects.equals(equipmentName, that.equipmentName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roomId, equipmentName);
  }
}
