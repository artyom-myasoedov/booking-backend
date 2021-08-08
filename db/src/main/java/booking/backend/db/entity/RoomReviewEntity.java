package booking.backend.db.entity;

import javax.persistence.*;

@Table(schema = "booking", name = "room_reviews")
@Entity(name = "room_reviews")
public class RoomReviewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id")
  private Integer id;

  @Column(name = "room_id")
  private Integer roomId;

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
