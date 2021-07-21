package booking.backend.db.entity;

import javax.persistence.*;

//TODO как делать неполные объекты, например комната с отзывами и без
@Table(name = "rooms", schema = "booking")
@Entity(name = "rooms")
public class RoomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "room_id")
  private Integer id;

  private Integer square;

  private Integer capacity;
}
