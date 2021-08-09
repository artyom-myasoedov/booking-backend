package booking.backend.service.model;

import booking.backend.service.validation.RoomReviewIdentical;

import javax.validation.constraints.NotNull;

@RoomReviewIdentical
public class RoomReviewUpdateDto {
  @NotNull(message = "id.is-null")
  private Integer id;

  @NotNull(message = "roomId.is-null")
  private Integer roomId;

  @NotNull(message = "rating.is-null")
  private Integer rating;

  @NotNull(message = "description.is-null")
  private String description;

  @NotNull(message = "authorId.is-null")
  private Integer authorId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Integer authorId) {
    this.authorId = authorId;
  }
}
