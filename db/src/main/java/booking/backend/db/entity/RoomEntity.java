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
    @NamedAttributeNode("landlord"),
    @NamedAttributeNode(value = "typesOfRent", subgraph = "typesOfRent"),
    @NamedAttributeNode(value = "reviews", subgraph = "reviews"),
  },
  subgraphs = {
    @NamedSubgraph(
      name =
    ),

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

  @ManyToOne(targetEntity = )
  private Integer landlord;

  @Column(name = "capacity")
  private Integer capacity;

  @Column(name = "address")
  private String address;

  @Column(name = "description")
  private String description;

  @Column(name = "min_rental_period")
  private Integer minRentalPeriod;

  @OneToMany
  private List<TypeOfRentEntity> typeOfRents;

  @OneToMany
  private List<?> reviews;



}
