package booking.backend.db.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "bookings", schema = "booking")
@Entity(name = "bookings")
public class BookingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "booking_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(
    name = "room_id",
    referencedColumnName = "room_id"
  )
  private RoomEntity room;

  @ManyToOne
  @JoinColumn(
    name = "tenant_id",
    referencedColumnName = "user_id"
  )
  private UserEntity tenant;

  @Column(name = "rental_period")
  private Integer rentalPeriod;

  @Column(name = "rental_start_date")
  private Instant rentalStartDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoomEntity getRoom() {
    return room;
  }

  public void setRoom(RoomEntity room) {
    this.room = room;
  }

  public UserEntity getTenant() {
    return tenant;
  }

  public void setTenant(UserEntity tenant) {
    this.tenant = tenant;
  }

  public Integer getRentalPeriod() {
    return rentalPeriod;
  }

  public void setRentalPeriod(Integer rentalPeriod) {
    this.rentalPeriod = rentalPeriod;
  }

  public Instant getRentalStartDate() {
    return rentalStartDate;
  }

  public void setRentalStartDate(Instant rentalStartDate) {
    this.rentalStartDate = rentalStartDate;
  }
}
