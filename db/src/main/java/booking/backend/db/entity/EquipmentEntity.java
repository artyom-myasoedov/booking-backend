package booking.backend.db.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "equipments")
@Table(name = "rooms_equipments", schema = "booking")
public class EquipmentEntity {

  @EmbeddedId
  private RoomEquipmentId id;

  @Column(name = "description")
  private String description;

  public RoomEquipmentId getId() {
    return id;
  }

  public void setId(RoomEquipmentId id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
