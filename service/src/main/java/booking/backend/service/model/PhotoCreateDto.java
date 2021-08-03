package booking.backend.service.model;

public class PhotoCreateDto {

  private Integer roomId;

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
