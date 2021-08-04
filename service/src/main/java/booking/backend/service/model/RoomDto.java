package booking.backend.service.model;

import booking.backend.db.entity.RoomStatus;

public class RoomDto extends RoomCreateDto {

  private Integer id;

  private RoomStatus roomStatus;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoomStatus getRoomStatus() {
    return roomStatus;
  }

  public void setRoomStatus(RoomStatus roomStatus) {
    this.roomStatus = roomStatus;
  }
}
