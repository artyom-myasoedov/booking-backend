package booking.backend.db.entity;


import javax.persistence.*;

@Entity
@Table(name = "room_photos", schema = "booking")
public class PhotoEntity {

  @Column(name = "room_photo_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer roomPhotoId;

  @Column(name = "room_id")
  private Integer roomId;

  @Column(name = "photo")
  private byte[] photo;

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

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }
}
