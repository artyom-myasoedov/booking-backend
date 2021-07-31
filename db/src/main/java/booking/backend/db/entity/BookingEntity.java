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

  @Column(name = "room_id")
  private Integer room_id;

  @Column(name = "tenant_id")
  private Integer tenant_id;

  @Column(name = "rental_period")
  private Integer rental_period;

  @Column(name = "rental_start_date")
  private Instant rental_start_date;


  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public Integer getRoom_id() {
    return room_id;
  }

  public void setRoom_id(Integer room_id) {
    this.room_id = room_id;
  }

  public Integer getTenant_id() {
    return tenant_id;
  }

  public void setTenant_id(Integer tenant_id) {
    this.tenant_id = tenant_id;
  }

  public Integer getRental_period() {
    return rental_period;
  }

  public void setRental_period(Integer rental_period) {
    this.rental_period = rental_period;
  }

  public Instant getRental_start_date() {
    return rental_start_date;
  }

  public void setRental_start_date(Instant rental_start_date) {
    this.rental_start_date = rental_start_date;
  }
}
