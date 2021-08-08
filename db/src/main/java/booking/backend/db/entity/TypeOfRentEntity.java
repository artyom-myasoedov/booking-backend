package booking.backend.db.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "rooms_types_of_rent", schema = "booking")
@Entity(name = "roomsTypesOfRent")
public class TypeOfRentEntity {

  @Column(name = "price")
  private BigDecimal price;

  @EmbeddedId
  private RoomTypeOfRentId id;

  @Column(name = "type_of_rent_id", insertable = false, updatable = false)
  private TypeOfRent typeOfRent;


  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public RoomTypeOfRentId getId() {
    return id;
  }

  public void setId(RoomTypeOfRentId id) {
    this.id = id;
  }

  public TypeOfRent getTypeOfRent() {
    return typeOfRent;
  }

  public void setTypeOfRent(TypeOfRent typeOfRent) {
    this.typeOfRent = typeOfRent;
  }
}
