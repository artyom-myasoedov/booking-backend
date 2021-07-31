package booking.backend.db.entity;


import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "room_photos", schema = "booking")
public class PhotoUrlEntity {

  @Column(name = "room_photo_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer roomPhotoId;

  @Column(name = "room_id")
  private Integer roomId;

  @Column(name = "photo_url")
  private URL photoUrl;

  public Integer getRoomPhotoId() {
    return roomPhotoId;
  }

  public void setRoomPhotoId(Integer roomPhotoId) {
    this.roomPhotoId = roomPhotoId;
  }

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public URL getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(URL photoUrl) {
    this.photoUrl = photoUrl;
  }
}
