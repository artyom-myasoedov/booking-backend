package booking.backend.db.entity;

import javax.persistence.*;

@Table(schema = "booking", name = "reviews")
@Entity(name = "reviews")
public class ReviewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id")
  private Integer id;

  @Column(name = "rated_entity_id")
  private Integer ratedEntityId;

  @Column(name = "rating")
  private Integer rating;

  @Column(name = "description")
  private String description;

  @Column(name = "author_id")
  private Integer authorId;

  @Column(name = "review_target_id")
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
