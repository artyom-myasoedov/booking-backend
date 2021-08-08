package booking.backend.service.model;

import booking.backend.service.validation.RoomExists;

import javax.validation.constraints.NotNull;

public class PhotoCreateDto {

  @NotNull(message = "roomId.is-null")
  @RoomExists
  private Integer roomId;

  @NotNull(message = "photo.is-null")
  private byte[] photo;

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }
}
