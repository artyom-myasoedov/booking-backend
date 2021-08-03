package booking.backend.service.model;

import booking.backend.db.entity.RoomEntity;
import booking.backend.db.entity.UserEntity;

import java.time.Instant;

public class BookingDto {
  private Integer id;
  private RoomEntity roomEntity;
  private UserEntity userEntity;
  private Integer rentalPeriod;
  private Instant rentalStartDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoomEntity getRoomEntity() {
    return roomEntity;
  }

  public void setRoomEntity(RoomEntity roomEntity) {
    this.roomEntity = roomEntity;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(UserEntity userEntity) {
    this.userEntity = userEntity;
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
