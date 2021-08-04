package booking.backend.service.model;

import booking.backend.db.entity.ReviewTarget;
import booking.backend.db.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewDto {
  @JsonProperty("review_id")
  private Integer id;

  @JsonProperty("rated_entity_id")
  private Integer ratedEntityId;

  @JsonProperty("rating")
  private Integer rating;

  @JsonProperty("description")
  private String description;

  @JsonProperty("author")
  private UserEntity author;

  @JsonProperty("review_target_id")
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

  public UserEntity getAuthor() {
    return author;
  }

  public void setAuthor(UserEntity author) {
    this.author = author;
  }

  public ReviewTarget getReviewTarget() {
    return reviewTarget;
  }

  public void setReviewTarget(ReviewTarget reviewTarget) {
    this.reviewTarget = reviewTarget;
  }
}
