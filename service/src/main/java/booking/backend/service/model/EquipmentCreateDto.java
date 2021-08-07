package booking.backend.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipmentCreateDto {

  private Integer roomId;

  @JsonProperty("name")
  private String equipmentName;

  private String description;

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
