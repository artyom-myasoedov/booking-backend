package booking.backend.service.model;

import booking.backend.db.entity.RoomStatus;
import booking.backend.db.entity.TypeOfRoom;

import java.util.List;

public class RoomDto {

  private Integer id;

  private Integer square;

  private TypeOfRoom typeOfRoom;

  private RoomStatus roomStatus;

  private UserDto landlord;

  private Integer capacity;

  private String address;

  private String description;

  private Integer minRentalPeriod;

  private List<EquipmentDto> equipments;

  private List<TypeOfRentDto> typesOfRent;

  private List<PhotoUrlDto> photoUrls;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSquare() {
    return square;
  }

  public void setSquare(Integer square) {
    this.square = square;
  }

  public TypeOfRoom getTypeOfRoom() {
    return typeOfRoom;
  }

  public void setTypeOfRoom(TypeOfRoom typeOfRoom) {
    this.typeOfRoom = typeOfRoom;
  }

  public RoomStatus getRoomStatus() {
    return roomStatus;
  }

  public void setRoomStatus(RoomStatus roomStatus) {
    this.roomStatus = roomStatus;
  }

  public UserDto getLandlord() {
    return landlord;
  }

  public void setLandlord(UserDto landlord) {
    this.landlord = landlord;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getMinRentalPeriod() {
    return minRentalPeriod;
  }

  public void setMinRentalPeriod(Integer minRentalPeriod) {
    this.minRentalPeriod = minRentalPeriod;
  }

  public List<EquipmentDto> getEquipments() {
    return equipments;
  }

  public void setEquipments(List<EquipmentDto> equipments) {
    this.equipments = equipments;
  }

  public List<TypeOfRentDto> getTypesOfRent() {
    return typesOfRent;
  }

  public void setTypesOfRent(List<TypeOfRentDto> typesOfRent) {
    this.typesOfRent = typesOfRent;
  }

  public List<PhotoUrlDto> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<PhotoUrlDto> photoUrls) {
    this.photoUrls = photoUrls;
  }
}
