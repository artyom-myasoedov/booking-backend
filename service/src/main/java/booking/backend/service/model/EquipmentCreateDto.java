package booking.backend.service.model;

import booking.backend.service.validation.RoomExists;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipmentCreateDto {

  @NotNull(message = "roomId.is-null")
  @RoomExists
  private Integer roomId;

  @JsonProperty("name")
  @NotBlank(message = "equipmentName.is-blank")
  @Size(max = 250, message = "equipmentName.is-too-long")
  private String equipmentName;

  @NotBlank(message = "description.is-blank")
  @Size(max = 1000, message = "description.is-too-long")
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
