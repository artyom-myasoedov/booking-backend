package booking.backend.db.converter;

import booking.backend.db.entity.RoomStatus;

import javax.persistence.AttributeConverter;

public class RoomStatusConverter implements AttributeConverter<RoomStatus, Integer> {
  @Override
  public Integer convertToDatabaseColumn(RoomStatus attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public RoomStatus convertToEntityAttribute(Integer dbData) {
    return RoomStatus.fromId(dbData).orElse(null);
  }

}
