package booking.backend.service.model;

import booking.backend.db.entity.ReviewTarget;
import booking.backend.service.validation.ReviewIdentical;

import javax.validation.constraints.NotNull;

@ReviewIdentical
public class ReviewUpdateDto {
  @NotNull(message = "id.is-null")
  private Integer id;

  @NotNull(message = "ratedEntityId.is-null")
  private Integer ratedEntityId;

  @NotNull(message = "rating.is-null")
  private Integer rating;

  @NotNull(message = "description.is-null")
  private String description;

  @NotNull(message = "authorId.is-null")
  private Integer authorId;

  @NotNull(message = "reviewTarget.is-null")
  private ReviewTarget reviewTarget;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRatedEntityId() {
    return ratedEntityId;
  }

  public void setRatedEntityId(Integer ratedEntityId) {
    this.ratedEntityId = ratedEntityId;
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

  public ReviewTarget getReviewTarget() {
    return reviewTarget;
  }

  public void setReviewTarget(ReviewTarget reviewTarget) {
    this.reviewTarget = reviewTarget;
  }
}
