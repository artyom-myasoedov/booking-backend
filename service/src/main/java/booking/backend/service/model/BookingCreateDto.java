package booking.backend.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class BookingCreateDto {
  @JsonProperty("room")
  private RoomDto room;

  @JsonProperty("tenant")
  private UserDto tenant;

  @JsonProperty("periodOfRent")
  private Integer periodOfBooking;

  @JsonProperty("rentalStartDate")
  private Instant rentalStartDate;

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
}
