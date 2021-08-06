package booking.backend.db.entity;

import javax.persistence.*;

@Entity(name = "equipments")
@Table(name = "rooms_equipments", schema = "booking")
public class EquipmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "equipment_id")
  private Integer equipmentId;

  @Column(name = "description")
  private String description;

  @Column(name = "room_id")
  private Integer roomId;

  @Column(name = "equipment_name")
  private String equipmentName;

  public Integer getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(Integer equipmentId) {
    this.equipmentId = equipmentId;
  }

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
