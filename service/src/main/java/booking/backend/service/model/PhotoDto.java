package booking.backend.service.model;


public class PhotoDto extends PhotoCreateDto {

  private Integer roomPhotoId;

  public Integer getRoomPhotoId() {
    return roomPhotoId;
  }

  public void setRoomPhotoId(Integer roomPhotoId) {
    this.roomPhotoId = roomPhotoId;
  }
}
