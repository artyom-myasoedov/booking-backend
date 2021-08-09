package booking.backend.service.model;

import booking.backend.service.validation.UserReviewIdentical;

import javax.validation.constraints.NotNull;

@UserReviewIdentical
public class UserReviewUpdateDto {
  @NotNull(message = "id.is-null")
  private Integer id;

  @NotNull(message = "userId.is-null")
  private Integer userId;

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

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
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
