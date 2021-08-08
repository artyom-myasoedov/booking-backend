package booking.backend.service.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipmentDto extends EquipmentCreateDto {

  @NotNull(message = "equipmentId.is-null")

  private Integer equipmentId;

  public Integer getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(Integer equipmentId) {
    this.equipmentId = equipmentId;
  }
}
