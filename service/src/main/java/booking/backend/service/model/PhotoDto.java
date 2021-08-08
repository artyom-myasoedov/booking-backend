package booking.backend.service.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class PhotoDto extends PhotoCreateDto {

  @JsonProperty("id")
  @NotNull(message = "photoId.is-null")
  private Integer roomPhotoId;

  public Integer getRoomPhotoId() {
    return roomPhotoId;
  }

  public void setRoomPhotoId(Integer roomPhotoId) {
    this.roomPhotoId = roomPhotoId;
  }
}
