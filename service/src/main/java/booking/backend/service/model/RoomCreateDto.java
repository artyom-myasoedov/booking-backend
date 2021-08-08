package booking.backend.service.model;

import booking.backend.db.entity.TypeOfRoom;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class RoomCreateDto {

  @JsonProperty("size")
  @NotNull(message = "square.is-null")
  @Min(value = 0, message = "square.is-negative")
  private Integer square;

  @NotNull(message = "typeOfRoom.is-null")
  private TypeOfRoom typeOfRoom;

  @NotNull(message = "landlord.is-null")
  private UserDto landlord;

  @JsonProperty("numberOfPeople")
  @NotNull(message = "capacity.is-null")
  @Min(value = 0, message = "capacity.is-negative")
  private Integer capacity;

  @NotBlank(message = "address.is-null")
  @Size(max = 255, message = "address.is-too-long")
  private String address;

  @NotBlank(message = "description.is-null")
  @Size(max = 1000, message = "description.is-too-long")
  private String description;

  @NotNull(message = "minRentalPeriod.is-null")
  @Min(value = 0, message = "minRentalPeriod.is-negative")
  private Integer minRentalPeriod;

  @NotNull(message = "equipments.is-null")
  private List<EquipmentDto> equipments;

  @NotNull(message = "typesOfRent.is-null")
  private List<TypeOfRentDto> typesOfRent;

  @NotNull(message = "photos.is-null")
  private List<PhotoDto> photos;

  public List<TypeOfRentDto> getTypesOfRent() {
    return typesOfRent;
  }

  public void setTypesOfRent(List<TypeOfRentDto> typesOfRent) {
    this.typesOfRent = typesOfRent;
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

  public List<PhotoDto> getPhotos() {
    return photos;
  }

  public void setPhotos(List<PhotoDto> photos) {
    this.photos = photos;
  }
}
