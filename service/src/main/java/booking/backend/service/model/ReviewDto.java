package booking.backend.service.model;

import booking.backend.db.entity.ReviewTarget;
import booking.backend.db.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class ReviewDto {
  private Integer id;

  private Integer ratedEntityId;

  private Integer rating;

  private String description;

  private Integer authorId;

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
