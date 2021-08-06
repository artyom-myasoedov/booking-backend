package booking.backend.service.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PhotoDto extends PhotoCreateDto {

  @JsonProperty("id")
  private Integer roomPhotoId;

  public Integer getRoomPhotoId() {
    return roomPhotoId;
  }

  public void setRoomPhotoId(Integer roomPhotoId) {
    this.roomPhotoId = roomPhotoId;
  }
}
