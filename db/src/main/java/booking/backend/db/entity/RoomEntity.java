package booking.backend.db.entity;

import javax.persistence.*;

@Table(name = "rooms", schema = "booking")
@Entity(name = "rooms")
public class RoomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "room_id")
  private Integer id;

  @Column(name = "square")
  private Integer square;

  @Column(name = "type")
  private TypeOfRoom typeOfRoom;

  @Column(name = "status")
  private RoomStatus roomStatus;

  @Column(name = "landlord_id")
  private Integer landlordId;

  @Column(name = "capacity")
  private Integer capacity;

  @Column(name = "address")
  private String address;

  @Column(name = "description")
  private String description;

  @Column(name = "min_rental_period")
  private Integer minRentalPeriod;


}
