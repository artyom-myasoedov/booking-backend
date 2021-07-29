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
      name = "type-of-rent",
      attributeNodes = {
        @NamedAttributeNode("price"),
        @NamedAttributeNode("id")
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
    referencedColumnName = "user_id",
    insertable = false,
    updatable = false
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
    name = "type_of_rent"
  )
  private List<TypeOfRentEntity> typeOfRents;

  @OneToMany()
  private List<ReviewEntity> reviews;

  @OneToMany()
  private List<String> photoUrls;


}
