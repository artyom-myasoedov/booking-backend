package booking.backend.db.entity;

import javax.persistence.*;

@Table(schema = "booking", name = "user_reviews")
@Entity(name = "user_reviews")
public class UserReviewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id")
  private Integer id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "rating")
  private Integer rating;

  @Column(name = "description")
  private String description;

  @Column(name = "author_id")
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
