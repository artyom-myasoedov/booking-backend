package booking.backend.service.model;

import java.time.Instant;

public class BookingDto {
  private Integer id;
  private RoomDto room;
  private UserDto tenant;
  private Integer periodOfBooking;
  private Instant rentalStartDate;
  private Instant rentalEndDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoomDto getRoom() {
    return room;
  }

  public void setRoom(RoomDto room) {
    this.room = room;
  }

  public UserDto getTenant() {
    return tenant;
  }

  public void setTenant(UserDto tenant) {
    this.tenant = tenant;
  }

  public Instant getRentalStartDate() {
    return rentalStartDate;
  }

  public void setRentalStartDate(Instant rentalStartDate) {
    this.rentalStartDate = rentalStartDate;
  }

  public Integer getPeriodOfBooking() {
    return periodOfBooking;
  }

  public void setPeriodOfBooking(Integer periodOfBooking) {
    this.periodOfBooking = periodOfBooking;
  }

  public Instant getRentalEndDate() {
    return rentalEndDate;
  }

  public void setRentalEndDate(Instant rentalEndDate) {
    this.rentalEndDate = rentalEndDate;
  }
}
