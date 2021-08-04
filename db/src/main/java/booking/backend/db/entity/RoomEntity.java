package booking.backend.db.entity;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(
        name = "room-with-reviews",
        attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode("square"),
                @NamedAttributeNode("typeOfRoom"),
                @NamedAttributeNode("roomStatus"),
                @NamedAttributeNode("capacity"),
                @NamedAttributeNode("description"),
                @NamedAttributeNode("minRentalPeriod"),
                @NamedAttributeNode(value = "landlord", subgraph = "landlord"),
                @NamedAttributeNode(value = "typesOfRent", subgraph = "typesOfRent"),
                @NamedAttributeNode(value = "reviews", subgraph = "reviews"),
                @NamedAttributeNode(value = "photoUrls", subgraph = "photo-url"),
                @NamedAttributeNode(value = "equipments", subgraph = "equipment")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "type-of-rent",
                        attributeNodes = {
                                @NamedAttributeNode("id"),
                                @NamedAttributeNode("price")
                        }
                ),
                @NamedSubgraph(
                        name = "review",
                        attributeNodes = {
                                @NamedAttributeNode("id"),
                                @NamedAttributeNode("ratedEntityId"),
                                @NamedAttributeNode("rating"),
                                @NamedAttributeNode("description"),
                                @NamedAttributeNode("authorId"),
                                @NamedAttributeNode("reviewTargetId")
                        }
                ),
                @NamedSubgraph(
                        name = "landlord",
                        attributeNodes = {
                                @NamedAttributeNode("id"),
                                @NamedAttributeNode("username"),
                                @NamedAttributeNode("firstName"),
                                @NamedAttributeNode("lastName"),
                                @NamedAttributeNode("photoPath"),
                                @NamedAttributeNode("role"),
                                @NamedAttributeNode("phoneNumber"),
                                @NamedAttributeNode("email")
                        }
                ),
                @NamedSubgraph(
                        name = "photo-url",
                        attributeNodes = {
                                @NamedAttributeNode("roomPhotoId"),
                                @NamedAttributeNode("roomId"),
                                @NamedAttributeNode("photo")
                        }
                ),
                @NamedSubgraph(
                        name = "equipment",
                        attributeNodes = {
                                @NamedAttributeNode("id"),
                                @NamedAttributeNode("description")
                        }
                )
        }
)
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

  @ManyToOne
  @JoinColumn(
          name = "landlord_id",
          referencedColumnName = "user_id"
  )
  private UserEntity landlord;

  @Column(name = "capacity")
  private Integer capacity;

  @Column(name = "address")
  private String address;

  @Column(name = "description")
  private String description;

  @Column(name = "min_rental_period")
  private Integer minRentalPeriod;

  @OneToMany
  @JoinColumn(
          name = "room_id",
          referencedColumnName = "room_id"
  )
  private List<TypeOfRentEntity> typesOfRent;

  @OneToMany
  @JoinColumn(
          name = "rated_entity_id",
          referencedColumnName = "room_id"
  )
  private List<ReviewEntity> reviews;

  @OneToMany
  @JoinColumn(
          name = "room_id",
          referencedColumnName = "room_id"
  )
  private List<PhotoEntity> photoUrls;

  @OneToMany
  @JoinColumn(
          name = "room_id",
          referencedColumnName = "room_id"
  )
  private List<EquipmentEntity> equipments;

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

  public UserEntity getLandlord() {
    return landlord;
  }

  public void setLandlord(UserEntity landlord) {
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

  public List<TypeOfRentEntity> getTypeOfRents() {
    return typesOfRent;
  }

  public void setTypeOfRents(List<TypeOfRentEntity> typeOfRents) {
    this.typesOfRent = typeOfRents;
  }

  public List<ReviewEntity> getReviews() {
    return reviews;
  }

  public void setReviews(List<ReviewEntity> reviews) {
    this.reviews = reviews;
  }

  public List<PhotoEntity> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<PhotoEntity> photoUrls) {
    this.photoUrls = photoUrls;
  }

  public List<EquipmentEntity> getEquipments() {
    return equipments;
  }

  public void setEquipments(List<EquipmentEntity> equipments) {
    this.equipments = equipments;
  }
}
